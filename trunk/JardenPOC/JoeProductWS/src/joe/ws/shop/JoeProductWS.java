package joe.ws.shop;

import javax.jws.*;

import joe.ws.shop.ProductVO;

import org.apache.beehive.controls.api.bean.Control;

@WebService
public class JoeProductWS {

	@Control
	private ProductDB productDB;

	public ProductVO getProduct(String supplier, String code) {
		System.out.println("JoeProductWS.getProduct('" + supplier + "', '" + code + "')");
		return productDB.getProduct(code);
	}
	public ProductVO[] getProducts() {
		System.out.println("JoeProductWS.getProducts()");
		return productDB.getAllProducts();
	}
}