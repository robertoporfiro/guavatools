package john.db;

import org.apache.beehive.controls.system.jdbc.JdbcControl;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ControlExtension
@JdbcControl.ConnectionDataSource(jndiName = "cgDataSource")
public interface ProductDB extends JdbcControl {
	static final long serialVersionUID = 1L;
	
	@JdbcControl.SQL(statement="insert into Product (code, name, description, price) values ({vo.code}, {vo.name}, {vo.description}, {vo.price})") 
	public void createProduct(ProductVO vo);

	@JdbcControl.SQL(statement="SELECT 'John' as supplier, code, name, description, price FROM Product WHERE code = {code}") 
	public ProductVO getProduct(String code);

	@JdbcControl.SQL(statement="SELECT 'John' as supplier, code, name, description, price FROM Product WHERE name like {name}") 
	public ProductVO[] getProductsByName(String name);

	@JdbcControl.SQL(statement="SELECT 'John' as supplier, code, name, description, price FROM Product") 
	public ProductVO[] getAllProducts();

	@JdbcControl.SQL(statement="DELETE FROM Product") 
	public int deleteAllProducts();

	@JdbcControl.SQL(statement="DELETE FROM Product WHERE code = {code}") 
	public int deleteProduct(String code);

}