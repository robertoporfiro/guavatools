package jarden.commons.tools;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Primes {
        private List<Long> primes= new ArrayList<Long>();
        private int primesFound=0;
        // how many primes were found during the last 1000 numbers
        private int primesFoundLastThousand=0;
        int primesThisThousand=0;
        int candidatesThisThousand=0;
        long currentCandidate=0;
        private Stats stats = new Stats();
        PrimesGUI gui;
        PrimesStore store;
        String fileStorePath="C:/temp/primes.math";
        
        
        public Primes(){
            try {
                store = new PrimesStore(new File(fileStorePath));
                System.out.println("loading primes from store...");
                primes = store.readPrimesFromFile();
                
                if(primes.size()>0){
                    System.out.println("Read "+primes.size()+" primes from store");
                    primesFound=primes.size();
                    stats.setNumberOfPrimesLoadedFromDisk(primesFound);
                    System.out.println("Continuing from: "+getLatestPrime());
                }
                else{
                    System.out.println("No primes found in file. Starting from 2");
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to proceed: "+e);
            }
            gui = new PrimesGUI();
            gui.launch(this);
        }
        
        
        public static void main(String[] args) {
            Primes primes = new Primes();
            PrimeSeeker seeker = primes.new PrimeSeeker();
            Thread seekerThread = new Thread(seeker);
            seekerThread.setName("seeker thread");
            seekerThread.start();
        }
        
        
        private void notifyStartLooking(){
            
        }
        
        private void notifyStopLooking(){
            
        }
        
        private synchronized long getLatestPrime(){
            return primes.size()>0 ? primes.get(primes.size()-1):2;
        }
        
        private synchronized void addPrime(long prime){
            try {
                store.addPrime(primesFound+","+prime);
            } catch (IOException e) {
                throw new RuntimeException(e);  // we want it to halt here.
            }
            primesFound++;
            primes.add(prime);
            
        }
        
        public class PrimeSeeker implements Runnable{

            public void run() {
                System.out.println("Running...");
                stats.setStartTime(new Date());
                long prime = getLatestPrime();
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    notifyStartLooking();
                    prime = lookForNextPrime(prime+1);
                    addPrime(prime);
                    notifyStopLooking();
                }
            }
            // ignore even numbers
            private long lookForNextPrime(long startPoint){
                if(isPrime(startPoint)){
                    return startPoint;
                } 
                
                // if startPoint is even, make it odd, and then go up in 2s from there.
                if(startPoint %2 ==0){
                    startPoint++;
                }
                boolean primeFound=false;
                while(!primeFound){
                    candidatesThisThousand+=2;
                    if(candidatesThisThousand>=1000){
                        primesFoundLastThousand=primesThisThousand;
                        candidatesThisThousand=0;
                        primesThisThousand=0;
                    }
                    if(isPrime(startPoint)){
                        primesThisThousand++;
                        return startPoint;
                    }
                    startPoint +=2;
                }
                
                return -1;
            }
            
            
            private boolean isPrime(long candidate){
                currentCandidate = candidate;
                double squareRootLimit = Math.sqrt(candidate);    // only search upto square root of candidate (Wow!)
                for(long prime: primes){
                    if(prime > squareRootLimit){
                        return true;
                    }
                    if(candidate % prime ==0){
                        return false;
                    }
                }
                return true;
            }
            
        }

        public Stats getStats() {
            stats.setNumberOfPrimesFound(this.primesFound);
            stats.setPrimesPerThousand(this.primesFoundLastThousand);
            stats.setLatestPrime(getLatestPrime());
            return stats ;
        }
}
