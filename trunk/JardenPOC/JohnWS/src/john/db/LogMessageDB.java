package john.db;

import java.util.Date;

import org.apache.beehive.controls.system.jdbc.JdbcControl;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ControlExtension
@JdbcControl.ConnectionDataSource(jndiName = "cgDataSource")
public interface LogMessageDB extends JdbcControl {
	static final long serialVersionUID = 1L;
	
	
	@JdbcControl.SQL(statement="insert into johnlog (message, createtime) values ({message}, {time})") 
	public void logMessage(String message, Date time);

	@JdbcControl.SQL(statement="insert into johnlog (owner, message, createtime) values ({owner}, {message}, {time})") 
	public void logMessage(String owner, String message, Date time);

	@JdbcControl.SQL(statement="SELECT ident, owner, message, createTime FROM JohnLog WHERE ident = {ident}") 
	public JohnLogVO getMessage(int ident);

	@JdbcControl.SQL(statement="SELECT ident, owner, message, createTime FROM JohnLog") 
	public JohnLogVO[] getAllMessages();

	@JdbcControl.SQL(statement="SELECT ident, owner, message, createTime FROM JohnLog where owner = {owner}") 
	public JohnLogVO[] getMessagesByOwner(String owner);

	@JdbcControl.SQL(statement="DELETE FROM JohnLog") 
	public int deleteAllMessages();

	@JdbcControl.SQL(statement="DELETE FROM JohnLog where owner = {owner}") 
	public int deleteMessagesByOwner(String owner);

	@JdbcControl.SQL(statement="DELETE FROM JohnLog WHERE ident = {ident}") 
	public int deleteMessage(int ident);
}