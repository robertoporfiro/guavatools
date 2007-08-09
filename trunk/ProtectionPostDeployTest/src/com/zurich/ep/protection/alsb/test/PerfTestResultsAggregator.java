package com.zurich.ep.protection.alsb.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PerfTestResultsAggregator {
    
    
    private PrintWriter writer;
    
    
    public PerfTestResultsAggregator(String filePath) throws IOException{
        File file = new File(filePath);
        writer = new PrintWriter(new FileWriter(file,true));
        System.out.println("PerfTestResultsAggregator created");
    }
    
    
    
    /**
     * Adds a result to an existing file
     * @param result
     * @throws IOException 
     */
    public void addResult(String result) throws IOException{
        writer.write(result);
        writer.write(",");
        writer.flush();
    }
    

    /**
     * Adds a result to an existing file
     * @param result
     * @throws IOException 
     */
    public void addResult(int result) throws IOException{
        addResult(""+result);
    }
    

    /**
     * Adds a result to an existing file
     * @param result
     * @throws IOException 
     */
    public void addResult(long result) throws IOException{
        addResult(""+result);
    }
    
    
    public void dispose() throws IOException{
        writer.flush();
        writer.close();
    }

    public void initialize(){
        writer.write("\n");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }
}
