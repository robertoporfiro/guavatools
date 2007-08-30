package jarden.commons.tools;

import java.util.Date;

public class Stats {
    private long latestPrime;
    private long numberOfPrimesFound;
    private Date startTime = new Date();
    private int highestFindRate=0;
    private long numberOfPrimesLoadedFromDisk=0;
    private int primesPerThousand;
    Runtime runtime = Runtime.getRuntime();

    public String getHeapStats() {
        long freeMem = runtime.freeMemory()/1024;
        long totalMem = runtime.totalMemory() /1024;
        return freeMem+"k (free) / "+totalMem+"k (max)";
    }

    public long getLatestPrime() {
        return latestPrime;
    }



    public void setLatestPrime(long latestPrime) {
        this.latestPrime = latestPrime;
    }



    public long getNumberOfPrimesFound() {
        return numberOfPrimesFound;
    }

    public long getNumberOfPrimesFoundInThisSession() {
        return numberOfPrimesFound-numberOfPrimesLoadedFromDisk;
    }


    public void setNumberOfPrimesFound(long numberOfPrimesFound) {
        this.numberOfPrimesFound = numberOfPrimesFound;
    }



    public Date getStartTime() {
        return startTime;
    }



    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getElapsedTime(){
        long data = getElapsedTimeInMillis();
        return convertSecondsToDurationText(data/1000);
    }
    
    
    private String convertSecondsToDurationText(long data){
        // get minutes
        long seconds = data;
        int minutes = (int) (data / 60);
        seconds = seconds - (minutes * 60);
        int hours = (int) (data/3600);
        minutes = minutes - (hours*60);
        
        return hours+"h"+minutes+":"+seconds;
    }
    
    public long getElapsedTimeInMillis(){
        Date now = new Date();
        long millis = now.getTime() - this.startTime.getTime();
        if(millis <1000){
            return 1000;
        }
        return millis;
    }

    public int getHighestFindRate() {
        return highestFindRate;
    }
    /**
     * In seconds
     * @return
     */
    public int getSecondsToNextMillionMilestone(){
        // which million are we on at the moment?
        long latestPrime = this.getLatestPrime() ;  // cache this for this method invocation, so the calculation is thread-safe
        long curMillion = (latestPrime/1000000);
        long nextMillion = (curMillion +1)*1000000;
        int numberOfPrimesLeft = (int) (nextMillion - latestPrime);
        int secondsLeft = numberOfPrimesLeft / (this.getPrimesFoundPerSecond()>0 ? this.getPrimesFoundPerSecond() : 1);
//        System.out.println("Seconds left="+secondsLeft+"    primesLeft:"+numberOfPrimesLeft);
        return secondsLeft;
    }
    
    public String getTimeToNextMillionMilestoneText(){
        int t = getSecondsToNextMillionMilestone();
        return convertSecondsToDurationText(t);            
    }
    
    public String getSecondsToNextBillionMilestoneText(){
        int t = getSecondsToNextMillionMilestone();
        return convertSecondsToDurationText(t*1000);            
    }

    public int getPrimesFoundPerMinute(){
        int d = getPrimesFoundPerSecond() * 60;
        if(d > this.highestFindRate){
            highestFindRate= (int) d;
        }
        return d;
    }
    
    
    
    
    public int getPrimesFoundPerSecond(){
        long seconds = (getElapsedTimeInMillis() / 1000);
        if(seconds <1){
            return 0;
        }
        int d = (int) (getNumberOfPrimesFoundInThisSession() / seconds);
        return d;
    }

    public void setNumberOfPrimesLoadedFromDisk(long numberOfPrimesLoadedFromDisk) {
        this.numberOfPrimesLoadedFromDisk = numberOfPrimesLoadedFromDisk;
    }

    public int getPrimesPerThousand() {
        return primesPerThousand;
    }

    public void setPrimesPerThousand(int primesPerThousand) {
        this.primesPerThousand = primesPerThousand;
    }
}
