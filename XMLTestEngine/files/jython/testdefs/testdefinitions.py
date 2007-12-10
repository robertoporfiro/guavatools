## module testdefinitions

tests=[

    ########### general tests ######
    ["3626","testXML/TEX/Bug3626.xml","[boron] Commission Payable part for 1-Year Term Indemnity", ['is origo message','is origo response message','has warning status','has correct commission note for 1 year indemnity']],          
    ["3760","testXML/general/Bug3760.xml","[boron] decimal places disallowed in Benefit field", ['is origo message','is origo response message','has error status','has decimals error note']],          
    ["3481","testXML/general/Bug3481.xml","[boron] premium variations. id attribute in correct place", ['is origo message','is origo response message','has warning status','has correct premium variation id']],          
    ["3860","testXML/general/Bug3860.xml","[boron] People over 69 aren't allowed insurance.", ['is origo message','is origo response message','has error status']],
    ["3860-b","testXML/general/Bug3860-b.xml","[boron] People under 16 aren't allowed insurance.", ['is origo message','is origo response message','has error status']],    
    
]  
