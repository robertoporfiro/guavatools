
declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductJohnToJoeRequest/";
declare namespace ns0 = "http://joe/ws/shop";
declare namespace ns1 = "http://john/ws/product";

declare function xf:GetProductJohnToJoeRequest($getProduct1 as element(ns1:getProduct))
    as element(ns0:getProduct) {
        <ns0:getProduct>
            <ns0:supplier>{ data($getProduct1/ns1:supplier) }</ns0:supplier>
            <ns0:code>{ data($getProduct1/ns1:code) }</ns0:code>
        </ns0:getProduct>
};

declare variable $getProduct1 as element(ns1:getProduct) external;

xf:GetProductJohnToJoeRequest($getProduct1)
