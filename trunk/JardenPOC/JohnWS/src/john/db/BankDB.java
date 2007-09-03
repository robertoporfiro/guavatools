package john.db;

import org.apache.beehive.controls.system.jdbc.JdbcControl;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ControlExtension
@JdbcControl.ConnectionDataSource(jndiName = "cgDataSource")
public interface BankDB extends JdbcControl {
	static final long serialVersionUID = 1L;
	
	@JdbcControl.SQL(statement="insert into JardenAccount (userName, password, balance) values ({vo.userName}, {vo.password}, {vo.balance})") 
	public void createAccount(JardenAccountVO vo);

	@JdbcControl.SQL(statement="SELECT userName, password, balance FROM JardenAccount WHERE userName = {userName}") 
	public JardenAccountVO getAccount(String userName);

	@JdbcControl.SQL(statement="SELECT userName, balance FROM JardenAccount") 
	public JardenAccountVO[] getAllAccounts();

	@JdbcControl.SQL(statement="DELETE FROM JardenAccount") 
	public int deleteAllAccounts();

	@JdbcControl.SQL(statement="DELETE FROM JardenAccount WHERE userName = {userName}") 
	public int deleteAccount(String userName);

	@JdbcControl.SQL(statement="UPDATE JardenAccount set balance = {balance} WHERE userName = {userName}") 
	public int setBalance(String userName, double balance);

	@JdbcControl.SQL(statement="UPDATE JardenAccount set password = {password} WHERE userName = {userName}") 
	public int changePassword(String userName, String password);
}