package com.zurich.ep.protection.alsb.test.scratch;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

public class TestXPathPerf {
    private static String xmlFilePath="C:/bea/user_projects/w4WP_workspaces/Peet/ProtectionPostDeployTest/testXML/TEX/catastrophic/message1.xml";
    private static int iterations=1000000;
    private static int notifyGranularity=10000;
    
    public static void main(String[] args) throws XmlException, IOException {
        selectXPath("./message");
        selectXPath("./message/m_content/application/product/risk_benefit");
        selectXPath(".//risk_benefit");
        selectXPath(".//message");
        
        System.out.println("---------------- Phase II ----------------");
        
        selectXPath("./message");
        selectXPath("./message/m_content/application/product/risk_benefit");
        selectXPath(".//risk_benefit");
        selectXPath(".//message");
        
        System.out.println("---------------- Phase III ----------------");
        
        selectXPath("./message");
        selectXPath("./message/m_content/application/product/risk_benefit");
        selectXPath(".//risk_benefit");
        selectXPath(".//message");
        
    }
    
    private static void selectXPath(String xpath) throws XmlException, IOException{
        XmlObject xml = XmlObject.Factory.parse(new File(xmlFilePath));
        Date startTime = new Date();
        for(int i=0;i<iterations;i++){
            XmlObject[] obj = xml.selectPath(xpath
                            );
            if(i % notifyGranularity == 0){
                System.out.print(".");
            }
        }
        System.out.println("\n "+getElapsedTime(startTime)+" milliseconds:        Selected "+iterations+ " iterations of "+xpath);
    }
    
    private static long getElapsedTime(Date startTime){
        Date endTime = new Date();
        return ((endTime.getTime()-startTime.getTime()));        
    }

}
