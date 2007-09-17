
declare namespace xf = "http://tempuri.org/Transformations/src/john/GetProductsCombined/";
declare namespace ns0 = "java:john.db";
declare namespace ns1 = "http://john/ws/product";

declare function xf:GetProductsCombined($getAllProductsResponse1 as element(ns1:getAllProductsResponse),
    $getAllProductsResponse2 as element(ns1:getAllProductsResponse))
    as element(ns1:getAllProductsResponse) {
        <ns1:getAllProductsResponse>
            <ns1:return>
                {
                    for $ProductVO in $getAllProductsResponse1/ns1:return/ns0:ProductVO union $getAllProductsResponse2/ns1:return/ns0:ProductVO
                    return
                        <ns0:ProductVO>{ $ProductVO/@* , $ProductVO/node() }</ns0:ProductVO>
                }
            </ns1:return>
        </ns1:getAllProductsResponse>
};

declare variable $getAllProductsResponse1 as element(ns1:getAllProductsResponse) external;
declare variable $getAllProductsResponse2 as element(ns1:getAllProductsResponse) external;

xf:GetProductsCombined($getAllProductsResponse1,
    $getAllProductsResponse2)
