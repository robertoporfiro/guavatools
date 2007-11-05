#module validatordefinitions

# the syntax to be used here is: validator-name: XMLObjectTest(testGoal, testType,xpath [,optional value (for CONTAINS and EQUALS only)])
# current valid values for testType: NOT_EXISTS, EXISTS ,EQUALS, CONTAINS

from com.zurich.ep.protection.alsb.test import XMLObjectTest

validators={
    'cover_period has one child': XMLObjectTest("Cover period has one child",XMLObjectTest.EQUALS,"count(//product/risk_benefit/cover_period/*)","1"),
    'no variations': XMLObjectTest("Test that no variations exist",XMLObjectTest.NOT_EXISTS,".//message/product/client_specific_illustration/variation"),
    'has variations': XMLObjectTest("Test that at least one variation exists",XMLObjectTest.EXISTS,".//message/product/client_specific_illustration/variation"),    
    'is origo message': XMLObjectTest("Is this a valid origo message?",XMLObjectTest.EXISTS,".//m_content"),
    'is origo response message': XMLObjectTest("Is this a valid origo response ?",XMLObjectTest.EQUALS,".//message/m_control/message_type","Quotation Response"),
    'has error status': XMLObjectTest("Is status set to Error?",XMLObjectTest.EQUALS,".//message/m_content/b_control/quote_response_status","Error"),
    'has error note': XMLObjectTest("Does this message have an error note?",XMLObjectTest.EXISTS,".//message/m_content/b_control/quote_error_note"),
    'has non-error note': XMLObjectTest("Does this message have an non-error note?",XMLObjectTest.EXISTS,".//message/product/client_specific_illustration/note"),    
    'has success status': XMLObjectTest("Is status set to Success?",XMLObjectTest.EQUALS,".//message/m_content/b_control/quote_response_status","Success"),
    'has warning status': XMLObjectTest("Is status set to Warning?",XMLObjectTest.EQUALS,".//message/m_content/b_control/quote_response_status","Warning"),    
    'has OE note': XMLObjectTest("Does this message have an occupation eligibility note?",XMLObjectTest.CONTAINS,".//message/product/client_specific_illustration/note/reason","eligibility"),
    'has plan term note': XMLObjectTest("Does this message have a plan term not supported note?",XMLObjectTest.CONTAINS,".//message/m_content/b_control/quote_error_note","The plan term selected is not supported"),
    'has commencement date note': XMLObjectTest("Does this message have a commencement date note?",XMLObjectTest.CONTAINS,".//message/product/client_specific_illustration/variation/reason","The illustration assumes a commencement date of"),
    'has plan term rounded up message': XMLObjectTest("Does this message have a plan term rounded up message?",XMLObjectTest.CONTAINS,".//message/product/client_specific_illustration/variation/reason","rounded up"),
    'has ADL note': XMLObjectTest("Does this message have an ADL message?",XMLObjectTest.CONTAINS,".//message/product/client_specific_illustration/variation/reason","Activities"), 
    'risk benefit has type attribute': XMLObjectTest("Do the client_specific_illustration risk_benefits contain type attributes?",XMLObjectTest.EXISTS,".//message/product/client_specific_illustration/risk_benefit/@type"),
    'risk benefit has risk_events': XMLObjectTest("Do the client_specific_illustration risk_benefits contain at least one risk_event?",XMLObjectTest.EXISTS,".//message/product/client_specific_illustration/risk_benefit/risk_event"),
    'space bug fixed': XMLObjectTest("Has the space been removed from 'Life and Health '",XMLObjectTest.EQUALS,".//message/product/client_specific_illustration/risk_benefit/@type","Life And Health"), 
    'csi has indexation element': XMLObjectTest("does the indexation element now exist within the client_specific_illustration risk benefits",XMLObjectTest.EXISTS,".//message/product/client_specific_illustration/risk_benefit/cover_indexation"),     
    'has not supported note': XMLObjectTest("Does this message have a not supported error note?",XMLObjectTest.CONTAINS,".//message/m_content/b_control/quote_error_note","not supported"),
    'has decimals error note': XMLObjectTest("Does this message have a decimals not allowed error note?",XMLObjectTest.CONTAINS,".//message/m_content/b_control/quote_error_note","Sums Assured must be entered in whole pounds only"),
    'has correct premium variation id': XMLObjectTest("Is the premium variation id on the amount tag ?",XMLObjectTest.EXISTS,".//message/m_content/application/product/risk_benefit/risk_contribution/contribution/amount/@id"),    
    'has correct commission note for 1 year indemnity': XMLObjectTest("has correct commission note for 1 year indemnity",XMLObjectTest.CONTAINS,".//message/m_content/application/product/client_specific_illustration/commission_entitlement/free_text","followed by"),    
    'has no relates to id': XMLObjectTest("The note nodes should not have a relates to field",XMLObjectTest.NOT_EXISTS,".//product/client_specific_illustration/note/relates_to"),    
    'quote details in right place': XMLObjectTest("Quote details should come after increment details",XMLObjectTest.EXISTS,".//product/following-sibling::*[1]"),        
    'has either end_age or term but not both': XMLObjectTest("has either end_age or term but not both",XMLObjectTest.NOT_EXISTS,"//product/risk_benefit/cover_period/*[not(exists(@id))]"),        

#    'sums assured are to 2 decimal places': XMLObjectTest("Checks that the sums assured are to 2 decimal places",XMLObjectTest.EXISTS,"for $rb in .//message/m_content/application/product/client_specific_illustration/risk_benefit[exists(lump_sum_benefit)] return $rb/lump_sum_benefit[not(contains(amount,\".00\"))]"),        NOT WORKING WITH CURRENT XQUERY IMPL :-(

    
    
     

} 