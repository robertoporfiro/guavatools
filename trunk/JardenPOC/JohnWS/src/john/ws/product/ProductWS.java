package john.ws.product;

import java.util.ArrayList;

import javax.jws.*;
import org.apache.beehive.controls.api.bean.Control;
import john.db.ProductDB;
import john.db.ProductVO;

@WebService
public class ProductWS {

	@Control
	private ProductDB productDB;

	public ProductVO[] getAllProducts() {
		System.out.println("ProductWS.getAllProducts()");
		return productDB.getAllProducts();
	}
	public ProductVO getProduct(String supplier, String code) {
		System.out.println("ProductWS.getProduct('" + supplier + "', '" + code + "')");
		return productDB.getProduct(code);
	}
	/**
	 * Return all Products that match pattern specified by vo.
	 * if code supplied, return exactly matching product
	 * else return all products matching name (if supplied)
	 * 	and less than price (if supplied).
	 * @param vo
	 * @return
	 */
	public ProductVO[] getMatchingProducts(ProductVO vo) {
		System.out.println("ProductWS.getMatchingProducts(" + vo + ")");
		String code = vo.getCode(); 
		if (code != null && code.trim().length() > 0) {
			return new ProductVO[] {productDB.getProduct(code)};
		}
		ProductVO[] prods;
		String name = vo.getName(); 
		if (name != null && name.trim().length() > 0) {
			prods = productDB.getProductsByName(name);
		}
		else {
			prods = productDB.getAllProducts();
		}
		double price = vo.getPrice();
		if (price > 0) {
			ArrayList prodList = new ArrayList();
			for (ProductVO prod: prods) {
				if (prod.getPrice() <= price) {
					prodList.add(prod);
				}
			}
			prods = (ProductVO[])prodList.toArray(new ProductVO[0]);
		}
		return prods;
	}
}