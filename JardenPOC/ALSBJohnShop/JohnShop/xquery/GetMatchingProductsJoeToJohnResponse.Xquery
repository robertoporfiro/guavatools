<?xml version="1.0" encoding="UTF-8"?>
<con:xqueryEntry xmlns:con="http://www.bea.com/wli/sb/resources/config">
  <con:xquery>declare namespace xf = "http://tempuri.org/Transformations/src/john/GetMatchingProductsJoeToJohnResponse/";
declare namespace ns0 = "java:joe.ws.shop";
declare namespace ns1 = "http://joe/ws/shop";
declare namespace ns3 = "http://john/ws/product";
declare namespace ns2 = "java:john.db";

declare function xf:GetMatchingProductsJoeToJohnResponse($getSelectedProductsResponse1 as element(ns1:getSelectedProductsResponse))
    as element(ns3:getMatchingProductsResponse) {
        &lt;ns3:getMatchingProductsResponse>
            {
                let $return := $getSelectedProductsResponse1/ns1:return
                return
                    &lt;ns3:return>
                        {
                            for $ProductVO in $return/ns0:ProductVO
                            return
                                &lt;ns2:ProductVO>
                                    &lt;ns2:Description>{ data($ProductVO/ns0:Description) }&lt;/ns2:Description>
                                    &lt;ns2:Ident>{ data($ProductVO/ns0:Ident) }&lt;/ns2:Ident>
                                    &lt;ns2:Price>{ data($ProductVO/ns0:Price) }&lt;/ns2:Price>
                                    &lt;ns2:Name>{ data($ProductVO/ns0:Name) }&lt;/ns2:Name>
                                    &lt;ns2:Supplier>{ data($ProductVO/ns0:Supplier) }&lt;/ns2:Supplier>
                                &lt;/ns2:ProductVO>
                        }
                    &lt;/ns3:return>
            }
        &lt;/ns3:getMatchingProductsResponse>
};

declare variable $getSelectedProductsResponse1 as element(ns1:getSelectedProductsResponse) external;

xf:GetMatchingProductsJoeToJohnResponse($getSelectedProductsResponse1)</con:xquery>
</con:xqueryEntry>