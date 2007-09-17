<?xml version="1.0" encoding="UTF-8"?>
<con:xqueryEntry xmlns:con="http://www.bea.com/wli/sb/resources/config">
  <con:xquery>declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductJohnToJoeRequest/";
declare namespace ns0 = "http://joe/ws/shop";
declare namespace ns1 = "http://john/ws/product";

declare function xf:GetProductJohnToJoeRequest($getProduct1 as element(ns1:getProduct))
    as element(ns0:getProduct) {
        &lt;ns0:getProduct>
            &lt;ns0:supplier>{ data($getProduct1/ns1:supplier) }&lt;/ns0:supplier>
            &lt;ns0:code>{ data($getProduct1/ns1:code) }&lt;/ns0:code>
        &lt;/ns0:getProduct>
};

declare variable $getProduct1 as element(ns1:getProduct) external;

xf:GetProductJohnToJoeRequest($getProduct1)</con:xquery>
</con:xqueryEntry>