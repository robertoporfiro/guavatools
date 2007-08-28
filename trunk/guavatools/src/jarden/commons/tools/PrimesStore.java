package jarden.commons.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrimesStore {
    
    BufferedWriter writer;
    BufferedReader reader;
    int bufferSize=50;  // hold this many primes before flushing
    int curBufCount=0;
    
    public PrimesStore(File fileStore) throws IOException{
        if(! fileStore.exists()){
            fileStore.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(fileStore,true);
        writer = new BufferedWriter(new OutputStreamWriter(fos));
        
        FileInputStream fis = new FileInputStream(fileStore);
        
        reader = new BufferedReader(new InputStreamReader(fis));
    }
    
    public void addPrime(String prime) throws IOException{
        writer.write(prime+"\n");
        curBufCount++;
        if(curBufCount<bufferSize){
            return;
        }
        writer.flush();
        curBufCount=0;
    }
    
    public List<Long> readPrimesFromFile() throws IOException{
        ArrayList<Long> list = new ArrayList<Long>();
        Date startDate = new Date();
        String line = reader.readLine();
        while(line!=null){
            Long p = getPrimeFromString(line);
            list.add(p);
            line = reader.readLine();
        }
        Date endDate = new Date();
        System.out.println(endDate.getTime() - startDate.getTime()+" millis");
        return list;
    }
    
    private Long getPrimeFromString(String line) {
        String longBit = line.substring(line.indexOf(',')+1,line.length());
        return new Long(longBit);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("stopping...");
        this.writer.close();
    }
    
}
