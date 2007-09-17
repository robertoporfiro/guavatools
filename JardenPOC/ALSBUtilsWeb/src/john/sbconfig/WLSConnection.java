package john.sbconfig;

public class WLSConnection {
	private String name;
	private String host;
	private String natHost;
	private int port;
	private String username;
	private String password;
	
	public WLSConnection() {
		
	}
	public WLSConnection(String name, String host, int port, String username, String password) {
		this(name, host, host, port, username, password);
	}
	public WLSConnection(String name, String host, String natHost, int port, String username, String password) {
		this.name = name;
		this.host = host;
		this.natHost = natHost;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNatHost() {
		return natHost;
	}
	public void setNatHost(String natHost) {
		this.natHost = natHost;
	}

}
