<?xml version="1.0" encoding="UTF-8"?>
<con:xqueryEntry xmlns:con="http://www.bea.com/wli/sb/resources/config">
  <con:xquery>declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductJoeToJohnResponse/";
declare namespace ns0 = "java:joe.ws.shop";
declare namespace ns1 = "http://joe/ws/shop";
declare namespace ns3 = "http://john/ws/product";
declare namespace ns2 = "java:john.db";

declare function xf:GetProductJoeToJohnResponse($getProductResponse1 as element(ns1:getProductResponse))
    as element(ns3:getProductResponse) {
        &lt;ns3:getProductResponse>
            {
                let $return := $getProductResponse1/ns1:return
                return
                    &lt;ns3:return>
                        &lt;ns2:Description>{ data($return/ns0:Description) }&lt;/ns2:Description>
                        &lt;ns2:Price>{ data($return/ns0:Price) }&lt;/ns2:Price>
                        &lt;ns2:Name>{ data($return/ns0:Name) }&lt;/ns2:Name>
                        &lt;ns2:Supplier>{ data($return/ns0:Supplier) }&lt;/ns2:Supplier>
                        &lt;ns2:Code>{ data($return/ns0:Code) }&lt;/ns2:Code>
                    &lt;/ns3:return>
            }
        &lt;/ns3:getProductResponse>
};

declare variable $getProductResponse1 as element(ns1:getProductResponse) external;

xf:GetProductJoeToJohnResponse($getProductResponse1)</con:xquery>
</con:xqueryEntry>