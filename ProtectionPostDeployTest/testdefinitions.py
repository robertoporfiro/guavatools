## module testdefinitions
#   
#
# KEY:
# SC single client
# MC multi client
# RB risk benefit
# BL benefit led
# SAL sum-assured led
tests=[

    ########### general tests ######
    ["cover_period has 1 child","testXML/TEX/AdilOne.xml","[boron] cover perido has 1 child", ['is origo message','is origo response message','has warning status','cover_period has one child']],    
    ["quote details in right place","testXML/TEX/AdilOne.xml","[boron] quote details in right place", ['is origo message','is origo response message','has warning status','quote details in right place']],
    ["no related to id on error","testXML/TEX/AdilOne.xml","[boron] Error notes should now not have a relates_to element", ['is origo message','is origo response message','has warning status','has no relates to id']],
    ["3626","testXML/TEX/Bug3626.xml","[boron] Commission Payable part for 1-Year Term Indemnity", ['is origo message','is origo response message','has warning status','has correct commission note for 1 year indemnity']],          
    ["3760","testXML/general/Bug3760.xml","[boron] decimal places disallowed in Benefit field", ['is origo message','is origo response message','has error status','has decimals error note']],          
    ["3481","testXML/general/Bug3481.xml","[boron] premium variations. id attribute in correct place", ['is origo message','is origo response message','has warning status','has correct premium variation id']],          
    ["3860","testXML/general/Bug3860.xml","[boron] People over 69 aren't allowed insurance.", ['is origo message','is origo response message','has error status']],
    ["3860-b","testXML/general/Bug3860-b.xml","[boron] People under 16 aren't allowed insurance.", ['is origo message','is origo response message','has error status']],    
   # (not sure why we are not implementing this rule yet) ["3860-c","testXML/general/Bug3860-c.xml","[boron] People over 54 aren't allowed TPD cover", ['is origo message','is origo response message','has error status']],        

   

    ########### the exchange #######
    ["Bug3712","testXML/TEX/Bug3712.xml","Nasty 10% bug: Rule 24 not being fired", ['is origo message','is origo response message','has error status']],
    ["Bug4170","testXML/TEX/Bug4170-Request.xml","TEX - incorrect response bug", ['is origo message','is origo response message','has warning status','has either end_age or term but not both']],    
    ["Test1","testXML/TEX/onlineQuote1.xml", "Basic TEX Request SC 1RB BL",['is origo message','is origo response message']],
    ["Test2","testXML/TEX/onlineQuote2.xml","Basic TEX Request", ['is origo message','is origo response message']],
    ["Test3","testXML/TEX/onlineQuote3.xml","Testing the LPP bug", ['is origo message','is origo response message']],
    ["Test4","testXML/TEX/onlineQuote4.xml","Testing the LPP bug", ['is origo message','is origo response message']],
    ["Test5","testXML/TEX/onlineQuote5.xml","Testing the LPP bug", ['is origo message','is origo response message']],
    ["Test6","testXML/TEX/onlineQuote6.xml","Testing the LPP bug", ['is origo message','is origo response message']],
    ["Test7","testXML/TEX/onlineQuote7-Gurdev.xml","Testing the LPP bug", ['is origo message','is origo response message']],
    ["Test8","testXML/TEX/onlineQuote10-Gurdev-LPPBug.xml","Testing the LPP bug", ['is origo message','is origo response message']],
    ["Test9","testXML/TEX/onlineQuote8-Gurdev.xml","Testing the LPP bug", ['is origo message','is origo response message','has error note', 'has error status']],    
    ["Bug1902","testXML/TEX/Bug1902.xml","TPD age should be less than 64", ['is origo message','is origo response message','has error note', 'has error status']],        
    ["Bug1895","testXML/TEX/Bug1895.xml","Message not displayed when sum assured max amount for CI is greater than £1000000", ['is origo message','is origo response message','has error note','has error status']],    
    ["Bug1906","testXML/TEX/Bug1906.xml","ADL quote not generated when CI selected with Suited occupation", ['is origo message','is origo response message','has variations','has ADL note']],    
    ["Bug1907","testXML/TEX/Bug1907.xml","ADL quote not generated when CI selected with Suited occupation", ['is origo message','is origo response message','has variations','has ADL note']],    
    ["Bug1953","testXML/TEX/Bug1953.xml","No Quote produced for CI LPP error - BEA382515 returned", ['is origo message','is origo response message','has warning status']],    
    ["Bug1962","testXML/TEX/Bug1962.xml","Quote is being incorrectly generated with plan term greater than 40 (Gty-LC)", ['is origo message','has error note','has error status','has plan term note']],         
    ["Bug1963","testXML/TEX/Bug1963.xml","Quote incorrectly generated for a GTY LC+ACIC where plan term less than 5", ['is origo message','has error note','has error status','has plan term note']],              
    ["Bug1964","testXML/TEX/Bug1964.xml","ALSB error when quoting on GTY ACIC where CI amount is greater than LC amount", ['is origo message','is origo response message','has error status','has plan term note']],                  
    ["Bug1778","testXML/TEX/Bug1778.xml","Quote still not returned and correcting DOB which has broken a business rule", ['is origo message','is origo response message','has error status']],                      
    ["Bug1975","testXML/TEX/Bug1975.xml","ALSB error occurs on selected LPP with Exact term defined by age", ['is origo message','is origo response message','has variations','has plan term rounded up message']],                      
    ["Bug2133","testXML/TEX/Bug2133.xml","Internal Server Error occurs when Reviewable CI plan term over 40 (Should have plan term error note)", ['is origo message','has error note','has error status','has plan term note']],                   
    ["Bug1952","testXML/TEX/Bug1952.xml","QuoteDetails term not populated", ['is origo message','is origo response message','has warning status']],
    ["Bug2089","testXML/TEX/Bug2089.xml","Internal Server Error occurs on DMC Joint life - Monthly Reviewable quote", ['is origo message','is origo response message','has error status']],
    ["Bug2144","testXML/TEX/Bug2144.xml","Annual Premium not being increased to the minimum allowed £80 on normal commission", ['is origo message','is origo response message','has warning status']],
    ["Bug3365","testXML/TEX/Bug3365.xml","Plan Term to-age variation note not working correctly", ['is origo message','is origo response message']],
    ["Bug3434","testXML/TEX/Bug3434.xml","Quote unexpectedly produced when plan term rule is violated", ['is origo message','is origo response message','has error status']],
    ["ADIL1","testXML/TEX/AdilOne.xml","interestRate2 bug", ['is origo message','is origo response message','has warning status']],    
    ["ADIL2","testXML/TEX/AdilTwo.xml","interestRate2 bug", ['is origo message','is origo response message','has warning status']],
    
     ########### webline ############
    ["commencementAgeTooHigh","testXML/Webline/Webline1.xml","Testing age of Client at commencement date must be 16 - 64", ['is origo message','has error status','has error note']],
    ["Bug1802","testXML/Webline/Bug1802.xml","Business rule for CI sum assured is triggered on a valid amount", ['is origo message','is origo response message']],    
    ["Bug1838","testXML/Webline/Bug1838.xml","Webline - Quote should not be returned for Reviewable CI when plan term less than 5 years", ['is origo message','has error note']],
    ["Bug1807","testXML/Webline/Bug1807.xml","[bug fixed] this now tests presence of 1 variation", ['is origo message','has variations']],
    ["Bug1839","testXML/Webline/Bug1839.xml","Plan Term For Reviewable Critical Illness must be in the range  5 - 40 years", ['is origo message','has error note','has error status']],
    ["Bug1850","testXML/Webline/Bug1850.xml","No quote produced when min monthly payment is less than £8", ['is origo message','has variations']],    
    ["Bug1851","testXML/Webline/Bug1851.xml","Quote results not displayed when annual payment is less than £80 for premium amount", ['is origo message','is origo response message','has variations']],
    ["Bug1858Mod","testXML/Webline/Bug1858.xml","(This is not the original bug def) CI sum-assured amount should be max £1 million", ['is origo message','is origo response message','has error note','has error status']],    
    ["Bug1859","testXML/Webline/Bug1859.xml","Quote is incorrectly generated when age exceeds 54 at commencement date with PTD selected", ['is origo message','is origo response message','has error note','has error status']],
    ["Bug1864","testXML/Webline/Bug1864.xml","Commencement date does not vary to 1st of current month", ['is origo message','is origo response message','has variations','has commencement date note']],
    ["Bug1869","testXML/Webline/Bug1869.xml","Check the eligibility note is added", ['is origo message','is origo response message','has variations','has OE note']],
    ["Bug1860","testXML/Webline/Bug1860.xml","Able to generate a quote with a mortgage interest rate of greater than 10%", ['is origo message','is origo response message','has error note','has error status']],
    ["Bug1928","testXML/Webline/Bug1928.xml","Internal Server Error occurs on DMC - Premium-Led - with WOP", ['is origo message','is origo response message','has warning status']],
    ["Bug1928b","testXML/Webline/Bug1928b.xml","Internal Server Error occurs on DMC - Premium-Led - with WOP", ['is origo message','is origo response message','has warning status']],    
    ["Bug1938","testXML/Webline/Bug1938.xml","A quote is being produced even though plan term is greater than 40 for a LPP GTY Life Cover", ['is origo message','has error note','has error status','has plan term note']],
    ["Bug1939","testXML/Webline/Bug1939.xml","Quote is produced even though the plan term is less than 5 for a Reviewable CI(LPP product)", ['is origo message','has error note','has error status','has plan term note']],
    ["Bug1940","testXML/Webline/Bug1940.xml","Quote returned when plan term for Reviewable Critical Illness is greater than 40", ['is origo message','has error note','has error status','has plan term note']],     
    ["Bug1867","testXML/Webline/Bug1867.xml","No occupation eligibility note displayed when WOP has been selected for DMC quote", ['is origo message','is origo response message','has variations','has OE note']],     
    ["Bug2019","testXML/Webline/Bug2019.xml","Unable to produce a DMC Joint Life quote", ['is origo message','is origo response message','has warning status']],
    ["Bug2019a","testXML/Webline/Bug2019a.xml","Unable to produce a DMC Joint Life quote", ['is origo message','is origo response message','has warning status']],
    ["Bug2034","testXML/Webline/Bug2034.xml","Unable to produce a DMC - CI Reviewable quote (Should have plan term error note)", ['is origo message','has error note','has error status','has plan term note']],                   
    ["Bug2343","testXML/Webline/Bug2343.xml","BEA Server Error", ['is origo message','is origo response message','has warning status']],
    ["Bug2344","testXML/Webline/Bug2344.xml","BEA Server Error", ['is origo message','is origo response message','has warning status']],
    ["Bug2346","testXML/Webline/Bug2346.xml","BEA Server Error", ['is origo message','is origo response message','has warning status']],    
   ["Bug2379","testXML/Webline/Bug2379.xml","BEA Server Error", ['is origo message','is origo response message','has warning status']],    
   ["Bug2655","testXML/Webline/Bug2655.xml","Duplicate user messages", ['is origo message','is origo response message','has warning status','has variations']],        
   ["Bug3699","testXML/Webline/Bug3699.xml","Prem_Led/DMC/Annual not producing quote when commission is flexed", ['is origo message','is origo response message','has warning status']],            
    

    
#
#    ########### positive solutions ##   
#
   ["LECIECI CI > LC","testXML/positive/PS_CI_CoverHigher.xml","DMC CI higher than lcov", ['is origo message','is origo response message','has warning status']],    
   ["LECIECI LC > CI","testXML/positive/PS_LifeCoverHigher.xml","DMC lcov higher than CI", ['is origo message','is origo response message','has error status']],    
   ["LevelTerm LPP","testXML/positive/LevelTerm.xml","Level Term LPP", ['is origo message','is origo response message','has warning status']],    
   ["Bug2829","testXML/positive/Bug2829.xml","CI > LC", ['is origo message','is origo response message','has warning status']],       
   ["Bug2818","testXML/positive/Bug2818.xml","", ['is origo message','is origo response message','has warning status']],          

    
    ########### assure web ##########   

   ["real assureweb DMC","testXML/assureweb/ASW DMC.xml","DMC Quote 2 Risk Covers", ['is origo message','is origo response message','has warning status']],
   ["real assureweb LPP","testXML/assureweb/LPPQuote.xml","LPP 2 Risk Covers", ['is origo message','is origo response message','has warning status']],
   ["Enhanced Risk Benefit element","testXML/assureweb/Bug2331.xml","Risk Benefit now contains risk_event and a type attribute", ['is origo message','is origo response message','risk benefit has type attribute','risk benefit has risk_events']],   
   ["Bug2515","testXML/assureweb/Bug2515.xml","Joint Life_LC CI_Monthly_All Premium Types - Quotes timed out no responses", ['is origo message','is origo response message']],      
   ["Bug3742","testXML/assureweb/Bug3742.xml","LC greater than CI - Incorrect Error Note", ['is origo message','is origo response message','has not supported note']],      
   
   
    ########### New term definition ##########   
    ["ToAgeDOB","testXML/TEX/newTermRules/ToAgeDOB.xml","ToAgeANB causes plan term rounded up message", ['is origo message','is origo response message','has variations','has plan term rounded up message']],                          
    
    ########### final day one bugs  ##########   
   ["Space Bug","testXML/TEX/Bug2144.xml","Client_Specific_Illustration risk benefits contain spurious spaces", ['is origo message','is origo response message','space bug fixed']],
   ["Indexation element in csi rb","testXML/TEX/Bug2144.xml","Do the CSI RBs contain Indexation elements?", ['is origo message','is origo response message','csi has indexation element']],   
    

    
]  
