<?xml version="1.0" encoding="UTF-8"?>
<con:xqueryEntry xmlns:con="http://www.bea.com/wli/sb/resources/config">
  <con:xquery>declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductsJoeToShopResponse/";
declare namespace ns0 = "http://jarden/ShoppingCart";
declare namespace ns1 = "http://joe/ws/cart";
declare namespace ns3 = "java:john.db";
declare namespace ns2 = "http://jarden/shop";

declare function xf:GetProductsJoeToShopResponse($getAllProductsResponse1 as element(ns1:getAllProductsResponse))
    as element(ns0:getAllProductsResponse) {
        &lt;ns0:getAllProductsResponse>
            &lt;ns0:return>
                {
                    for $ProductVO in $getAllProductsResponse1/ns1:return/ns3:ProductVO
                    return
                        &lt;ns2:values>
                            &lt;ns2:Description>{ data($ProductVO/ns3:Description) }&lt;/ns2:Description>
                            &lt;ns2:Price>{ data($ProductVO/ns3:Price) }&lt;/ns2:Price>
                            &lt;ns2:Name>{ data($ProductVO/ns3:Name) }&lt;/ns2:Name>
                            &lt;ns2:Supplier>{ data($ProductVO/ns3:Supplier) }&lt;/ns2:Supplier>
                            &lt;ns2:Code>{ data($ProductVO/ns3:Code) }&lt;/ns2:Code>
                        &lt;/ns2:values>
                }
            &lt;/ns0:return>
        &lt;/ns0:getAllProductsResponse>
};

declare variable $getAllProductsResponse1 as element(ns1:getAllProductsResponse) external;

xf:GetProductsJoeToShopResponse($getAllProductsResponse1)</con:xquery>
</con:xqueryEntry>