<?xml version="1.0" encoding="UTF-8"?>
<con:xqueryEntry xmlns:con="http://www.bea.com/wli/sb/resources/config">
  <con:xquery>declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductsCombined/";
declare namespace ns0 = "java:john.db";
declare namespace ns1 = "http://john/ws/product";

declare function xf:GetProductsCombined($getAllProductsResponse1 as element(ns1:getAllProductsResponse),
    $getAllProductsResponse2 as element(ns1:getAllProductsResponse))
    as element(ns1:getAllProductsResponse) {
        &lt;ns1:getAllProductsResponse>
            &lt;ns1:return>
                {
                    for $ProductVO in $getAllProductsResponse1/ns1:return/ns0:ProductVO
                    return
                        &lt;ns0:ProductVO>{ $ProductVO/@* , $ProductVO/node() }&lt;/ns0:ProductVO>,
                    for $ProductVO in $getAllProductsResponse2/ns1:return/ns0:ProductVO
                    return
                        &lt;ns0:ProductVO>{ $ProductVO/@* , $ProductVO/node() }&lt;/ns0:ProductVO>
                }
            &lt;/ns1:return>
        &lt;/ns1:getAllProductsResponse>
};

declare variable $getAllProductsResponse1 as element(ns1:getAllProductsResponse) external;
declare variable $getAllProductsResponse2 as element(ns1:getAllProductsResponse) external;

xf:GetProductsCombined($getAllProductsResponse1,
    $getAllProductsResponse2)</con:xquery>
</con:xqueryEntry>