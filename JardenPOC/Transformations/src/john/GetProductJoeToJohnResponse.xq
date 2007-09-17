
declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductJoeToJohnResponse/";
declare namespace ns0 = "java:joe.ws.shop";
declare namespace ns1 = "http://joe/ws/shop";
declare namespace ns3 = "http://john/ws/product";
declare namespace ns2 = "java:john.db";

declare function xf:GetProductJoeToJohnResponse($getProductResponse1 as element(ns1:getProductResponse))
    as element(ns3:getProductResponse) {
        <ns3:getProductResponse>
            {
                let $return := $getProductResponse1/ns1:return
                return
                    <ns3:return>
                        <ns2:Description>{ data($return/ns0:Description) }</ns2:Description>
                        <ns2:Price>{ data($return/ns0:Price) }</ns2:Price>
                        <ns2:Name>{ data($return/ns0:Name) }</ns2:Name>
                        <ns2:Supplier>{ data($return/ns0:Supplier) }</ns2:Supplier>
                        <ns2:Code>{ data($return/ns0:Code) }</ns2:Code>
                    </ns3:return>
            }
        </ns3:getProductResponse>
};

declare variable $getProductResponse1 as element(ns1:getProductResponse) external;

xf:GetProductJoeToJohnResponse($getProductResponse1)
