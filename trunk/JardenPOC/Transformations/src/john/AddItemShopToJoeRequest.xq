xquery version "1.0" encoding "Cp1252";


declare namespace xf = "http://tempuri.org/Transformations/src/john/AddItemShopToJoeRequest/";
declare namespace ns0 = "http://jarden/ShoppingCart";
declare namespace ns1 = "http://joe/ws/cart";

declare function xf:AddItemShopToJoeRequest($addItem1 as element(ns0:addItem))
    as element(ns1:addItem) {
        <ns1:addItem/>
};

declare variable $addItem1 as element(ns0:addItem) external;

xf:AddItemShopToJoeRequest($addItem1)
