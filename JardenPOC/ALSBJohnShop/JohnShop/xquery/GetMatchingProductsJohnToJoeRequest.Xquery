<?xml version="1.0" encoding="UTF-8"?>
<con:xqueryEntry xmlns:con="http://www.bea.com/wli/sb/resources/config">
  <con:xquery>declare namespace xf = "http://tempuri.org/Transformations/src/john/GetMatchingProductsJohnToJoeRequest/";
declare namespace ns0 = "java:joe.ws.shop";
declare namespace ns1 = "http://joe/ws/shop";
declare namespace ns3 = "http://john/ws/product";
declare namespace ns2 = "java:john.db";

declare function xf:GetMatchingProductsJohnToJoeRequest($getMatchingProducts1 as element(ns3:getMatchingProducts))
    as element(ns1:getSelectedProducts) {
        &lt;ns1:getSelectedProducts>
            {
                let $vo := $getMatchingProducts1/ns3:vo
                return
                    &lt;ns1:vo>
                        &lt;ns0:Description>{ data($vo/ns2:Description) }&lt;/ns0:Description>
                        &lt;ns0:Ident>{ data($vo/ns2:Ident) }&lt;/ns0:Ident>
                        &lt;ns0:Price>{ data($vo/ns2:Price) }&lt;/ns0:Price>
                        &lt;ns0:Name>{ data($vo/ns2:Name) }&lt;/ns0:Name>
                        &lt;ns0:Supplier>{ data($vo/ns2:Supplier) }&lt;/ns0:Supplier>
                    &lt;/ns1:vo>
            }
        &lt;/ns1:getSelectedProducts>
};

declare variable $getMatchingProducts1 as element(ns3:getMatchingProducts) external;

xf:GetMatchingProductsJohnToJoeRequest($getMatchingProducts1)</con:xquery>
</con:xqueryEntry>