declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductsFromJohnAndJoeResponse/";
declare namespace ns0 = "java:joe.ws.shop";
declare namespace ns1 = "http://joe/ws/shop";
declare namespace ns3 = "http://john/ws/product";
declare namespace ns2 = "java:john.db";

declare function xf:GetProductsFromJohnAndJoeResponse($getProductsResponse1 as element(ns1:getProductsResponse),
    $getAllProductsResponse1 as element(ns3:getAllProductsResponse))
    as element(ns3:getAllProductsResponse) {
        <ns3:getAllProductsResponse>
            <ns3:return>
                {
                    for $ProductVO in $getProductsResponse1/ns1:return/ns0:ProductVO
                    return
                        <ns2:ProductVO>
                            <ns2:Description>{ data($ProductVO/ns0:Description) }</ns2:Description>
                            <ns2:Price>{ data($ProductVO/ns0:Price) }</ns2:Price>
                            <ns2:Name>{ data($ProductVO/ns0:Name) }</ns2:Name>
                            <ns2:Supplier>{ data($ProductVO/ns0:Supplier) }</ns2:Supplier>
                            <ns2:Code>{ data($ProductVO/ns0:Code) }</ns2:Code>
                        </ns2:ProductVO>,
                       
                    for $ProductVO in $getAllProductsResponse1/ns3:return/ns2:ProductVO
                    return
                        <ns2:ProductVO>{ $ProductVO/@* , $ProductVO/node() }</ns2:ProductVO>
                }
            </ns3:return>
        </ns3:getAllProductsResponse>
};

declare variable $getProductsResponse1 as element(ns1:getProductsResponse) external;
declare variable $getAllProductsResponse1 as element(ns3:getAllProductsResponse) external;

xf:GetProductsFromJohnAndJoeResponse($getProductsResponse1,
    $getAllProductsResponse1)