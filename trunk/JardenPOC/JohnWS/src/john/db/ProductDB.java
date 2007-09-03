package john.db;

import org.apache.beehive.controls.system.jdbc.JdbcControl;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ControlExtension
@JdbcControl.ConnectionDataSource(jndiName = "cgDataSource")
public interface ProductDB extends JdbcControl {
	static final long serialVersionUID = 1L;
	
	@JdbcControl.SQL(statement="insert into Product (name, description, price) values ({vo.name}, {vo.description}, {vo.price})") 
	public void createProduct(ProductVO vo);

	@JdbcControl.SQL(statement="SELECT ident, 'John' as supplier, name, description, price FROM Product WHERE ident = {ident}") 
	public ProductVO getProduct(int ident);

	@JdbcControl.SQL(statement="SELECT ident, 'John' as supplier, name, description, price FROM Product WHERE name like {name}") 
	public ProductVO[] getProductsByName(String name);

	@JdbcControl.SQL(statement="SELECT ident, 'John' as supplier, name, description, price FROM Product") 
	public ProductVO[] getAllProducts();

	@JdbcControl.SQL(statement="DELETE FROM Product") 
	public int deleteAllProducts();

	@JdbcControl.SQL(statement="DELETE FROM Product WHERE ident = {ident}") 
	public int deleteProduct(String ident);

}