package com.zurich.ep.protection.alsb.test.consistency;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;



/**
 * Reads in a CSV file of tests and generates ConsistencyTests
 * @author GBEVVH8
 *
 */
public class ConsistencyTestCaseConfigurer {
    public static Collection generateTests(String filePath) throws Exception{
        Collection tests = new ArrayList();
        CsvReader reader = new CsvReader(filePath);
        System.out.println("returned");
        System.out.println(reader.getColumnCount());
        System.out.println("Zero"+reader.get(0));
        System.out.println(reader.get("1"+1));
        System.out.println(reader.get(2));
        while(reader.readRecord()){
            System.out.println("blahb"+reader.get(1));
            System.out.println(reader.get(2));            
        }
        System.out.println("End of records");
        
        return tests;
    }
    
    
    private static StringReader transpose(String filePath) throws Exception{
        CsvReader reader = new CsvReader(filePath);
        
        ArrayList<ArrayList<String>> columnArray =new ArrayList<ArrayList<String>>();
        while(reader.readRecord()){
            System.out.println("in read");
            ArrayList<String> rowArray = new ArrayList<String>();
            for(int i=0;i<reader.getColumnCount();i++){
                System.out.println("    in inner read");
                rowArray.add(reader.get(i));    
            }
            columnArray.add(rowArray);             
        }
        
//      first of all read the whole thing into a 2D array.
//        String[][] targetArray = new String[reader.getHeaderCount()][columnArray.size()];
        StringWriter targetWriter = new StringWriter();
        CsvWriter writer = new CsvWriter(targetWriter,';');
        
        
        for(int x=0;x<reader.getColumnCount();x++){
            ArrayList<String> rows = columnArray.get(x);
            for(int y=0;y<reader.getColumnCount();y++){
                System.out.println("Row:"+rows.get(y));
                writer.write(rows.get(y));
            }
            writer.endRecord();
        }
        writer.flush();
        targetWriter.flush();
        String s = targetWriter.toString();
        System.out.println("String"+s);
        targetWriter.close();
        System.out.println("returning");
        return new StringReader(s);
    }
    
    public static void main(String[] args) throws Exception {
        ConsistencyTestCaseConfigurer.generateTests("./csv/LPP Reviewable.csv");
    }

    
    
}



