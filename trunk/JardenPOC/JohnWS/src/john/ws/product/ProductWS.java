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
		return productDB.getAllProducts();
	}
	public ProductVO getProduct(int ident) {
		return productDB.getProduct(ident);
	}
	public ProductVO[] getMatchingProducts(ProductVO vo) {
		int ident = vo.getIdent(); 
		if (ident > 0) {
			return new ProductVO[] {productDB.getProduct(ident)};
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