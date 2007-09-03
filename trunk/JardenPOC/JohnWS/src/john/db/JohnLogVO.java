package john.db;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class JohnLogVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ident;
	private String owner;
	private String message;
	private Date createTime;
	private final static DateFormat dateFormat =
		DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
	// private final static DateFormat dateFormat =
	//	new SimpleDateFormat("yyyyMMMdd-HH:mm:ss");
	
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
