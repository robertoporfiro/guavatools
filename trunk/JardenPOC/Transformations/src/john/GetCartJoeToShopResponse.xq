
declare namespace xf = "http://tempuri.org/Transformations/src/john/GetCartJoeToShopResponse/";
declare namespace ns0 = "http://jarden/ShoppingCart";
declare namespace ns1 = "java:joe.ws.cart";
declare namespace ns3 = "http://jarden/shop";
declare namespace ns2 = "http://joe/ws/cart";

declare function xf:GetCartJoeToShopResponse($getCartResponse1 as element(ns2:getCartResponse))
    as element(ns0:getCartResponse) {
        <ns0:getCartResponse>
            <ns0:return>
                <ns3:TotalPrice>{ data($getCartResponse1/ns2:return/ns1:TotalPrice) }</ns3:TotalPrice>
                <ns3:Client>{ data($getCartResponse1/ns2:return/ns1:Client) }</ns3:Client>
                <ns3:AccountName>{ data($getCartResponse1/ns2:return/ns1:AccountName) }</ns3:AccountName>
                {
                    for $Items in $getCartResponse1/ns2:return/ns1:Items
                    return
                        <ns3:Items>
                            <ns3:Code>{ data($Items/ns1:Code) }</ns3:Code>
                            <ns3:Supplier>{ data($Items/ns1:Supplier) }</ns3:Supplier>
                            <ns3:Name>{ data($Items/ns1:Name) }</ns3:Name>
                            <ns3:Price>{ data($Items/ns1:Price) }</ns3:Price>
                            <ns3:Quantity>{ data($Items/ns1:Quantity) }</ns3:Quantity>
                        </ns3:Items>
                }
            </ns0:return>
        </ns0:getCartResponse>
};

declare variable $getCartResponse1 as element(ns2:getCartResponse) external;

xf:GetCartJoeToShopResponse($getCartResponse1)
