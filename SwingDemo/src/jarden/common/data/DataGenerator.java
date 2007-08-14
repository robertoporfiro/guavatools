package jarden.common.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class DataGenerator {
    
    private static Random random = new Random(new Date().getTime());
    private static Logger log = Logger.getLogger(DataGenerator.class.getName());
    
    private static String boysNamesFileName="jarden/common/data/boysNames.txt";
    private static List<String> boysNames = new ArrayList<String>();
    
    private static String girlsNamesFileName="jarden/common/data/girlsNames.txt";
    private static List<String> girlsNames = new ArrayList<String>();
    
    private static String streetNamesFileName="jarden/common/data/streetNames.txt";
    private static List<String> streetNames = new ArrayList<String>();
    
    private static String surnamesFileName="jarden/common/data/surnames.txt";
    private static List<String> surnames = new ArrayList<String>();
    
    static{
        Wobbler wobble = new Wobbler();
        Thread wobbleThread = new Thread(wobble);
        wobbleThread.start();
        try {
            loadLists();
        } catch (IOException e) {
            throw new RuntimeException("Unable to initialize class due to: "+e);
        }
    }
    
    public static String getSurname(){
        return surnames.get(random.nextInt(surnames.size()));
    }
    private static void loadLists() throws IOException {
        readFileIntoList(boysNamesFileName,boysNames);
        log.info("loaded "+boysNames.size()+" boys names");
        readFileIntoList(girlsNamesFileName,girlsNames);
        log.info("loaded "+girlsNames.size()+" girls names");
        readFileIntoList(streetNamesFileName,streetNames);
        log.info("loaded "+streetNames.size()+" street names");
        readFileIntoList(surnamesFileName,surnames);
        log.info("loaded "+surnames.size()+" surnames");
    }
    
    private static void readFileIntoList(String fileName, List<String> list) throws IOException {
        InputStream is = DataGenerator.class.getClassLoader().getResourceAsStream(fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String line = reader.readLine();
        int lines = 0;
        while(line != null){
            lines ++;
            list.add(line);
            line = reader.readLine();
        }
        
    }
    private static int getNameInvCounter=0;
    public static String getName(){
        // 50% of the time, return a girls name
        if(++ getNameInvCounter %2 == 0){
            return getGirlsName();
        }
        return getBoysName();
    }
    
    public static String getBoysName() {
        return boysNames.get(random.nextInt(boysNames.size()));
    }
    public static String getGirlsName() {
        return girlsNames.get(random.nextInt(girlsNames.size()));
    }
    
    public static String getFullName(){
        return getName()+" "+getSurname();
    }
    
    public static String getDOB(Date lowerLimit, Date upperLimit){
        return null;
    }
    public static Map getAddress(){
        return null;
    }
    
    public static int getNumberInRange(int lowerLimit, int upperLimit){
        return random.nextInt((upperLimit-lowerLimit))+lowerLimit;
    }
    
    /**
     * resets the seed every few minutes. 
     * @author GBEVVH8
     *
     */
    public static class Wobbler implements Runnable{
        Random r = new Random(new Date().getTime());
        long seedResetCount=0;
        
        public void run() {
            while(true){
                try {
                    int sleepTime = ((r.nextInt(5)+10) * 1000);
                    long freemem = Runtime.getRuntime().freeMemory();
                    System.out.println("sleeping for "+sleepTime+"millis");
                    if(sleepTime <0){
                        sleepTime = 0-sleepTime;
                    }
                    Thread.sleep(sleepTime);
                    System.out.println("resetting seed");
                    long newSeed = mutate(new Date().getTime(), freemem);
                    System.out.println(newSeed);
                    random.setSeed(newSeed);
                } catch (InterruptedException e) {
                   //ignore
                }
            }
        }
        
        private long mutate(long a, long b){
            if(++seedResetCount % 2==0){
                return (a | b) + salt();
            }else 
                if(seedResetCount% 7==0){
                    return (a/b) & salt();
                }else 
                    if(seedResetCount% 3==0){
                        return salt();
                    }
            
            
            return a & b + salt();
        }
        
        private long salt(){
            return random.nextLong();
        }
        
    }

    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world");
        System.out.println(getName());
        System.out.println(getName());
        System.out.println(getName());
        System.out.println(getName());
        System.out.println(getName());
        System.out.println(getName());
        System.out.println(getNumberInRange(11,14));
        System.out.println(getNumberInRange(11,14));
        System.out.println(getNumberInRange(11,14));
        System.out.println(getNumberInRange(11,14));
        System.out.println(getNumberInRange(11,14));
        
        System.out.println(getFullName());
        System.out.println(getFullName());
        System.out.println(getFullName());
        System.out.println(getFullName());
        System.out.println(getFullName());
        System.out.println(getFullName());
        System.out.println(getFullName());
        Thread.sleep(3600000);
       
    }
}

