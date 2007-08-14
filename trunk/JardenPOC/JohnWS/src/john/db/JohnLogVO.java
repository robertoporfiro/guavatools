package john.db;

import java.text.DateFormat;
import java.util.Date;

public class JohnLogVO {
	private int ident;
	private String message;
	private Date createTime;
	private static DateFormat dateFormat =
		DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
	
	public Date getCreateTime() {
		return createTime;
	}
	public String getCreateTimeString() {
		return dateFormat.format(createTime);
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getIdent() {
		return ident;
	}
	public void setIdent(int ident) {
		this.ident = ident;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString() {
		return ident + ": " + message;
	}
	
}
