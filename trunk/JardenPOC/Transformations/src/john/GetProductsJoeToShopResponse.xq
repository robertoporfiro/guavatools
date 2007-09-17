
declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductsJoeToShopResponse/";
declare namespace ns0 = "http://jarden/ShoppingCart";
declare namespace ns1 = "http://joe/ws/cart";
declare namespace ns3 = "java:john.db";
declare namespace ns2 = "http://jarden/shop";

declare function xf:GetProductsJoeToShopResponse($getAllProductsResponse1 as element(ns1:getAllProductsResponse))
    as element(ns0:getAllProductsResponse) {
        <ns0:getAllProductsResponse>
            <ns0:return>
                {
                    for $ProductVO in $getAllProductsResponse1/ns1:return/ns3:ProductVO
                    return
                        <ns2:values>
                            <ns2:Description>{ data($ProductVO/ns3:Description) }</ns2:Description>
                            <ns2:Price>{ data($ProductVO/ns3:Price) }</ns2:Price>
                            <ns2:Name>{ data($ProductVO/ns3:Name) }</ns2:Name>
                            <ns2:Supplier>{ data($ProductVO/ns3:Supplier) }</ns2:Supplier>
                            <ns2:Code>{ data($ProductVO/ns3:Code) }</ns2:Code>
                        </ns2:values>
                }
            </ns0:return>
        </ns0:getAllProductsResponse>
};

declare variable $getAllProductsResponse1 as element(ns1:getAllProductsResponse) external;

xf:GetProductsJoeToShopResponse($getAllProductsResponse1)
