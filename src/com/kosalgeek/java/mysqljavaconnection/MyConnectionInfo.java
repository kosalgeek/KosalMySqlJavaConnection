package com.kosalgeek.java.mysqljavaconnection;

public class MyConnectionInfo {
	private String driver = "com.mysql.jdbc.Driver";
	private String port;
	private String hostName;
	private String dbName;
	private String username;
	private String password;
	private String url;
	
	public MyConnectionInfo() {
		super();
	}
	
	public MyConnectionInfo(String dbName) {
		super();
		this.dbName = dbName;
		setPort("3306");
		setHostName("localhost");
		setUsername("root");
		setPassword("");
		setUrl("jdbc:mysql://"+hostName+":"+port+"/"+dbName);
	}
	
	public MyConnectionInfo(String dbName, String username, String password) {
		super();
		this.dbName = dbName;
		this.username = username;
		this.password = password;
		setPort("3306");
		setHostName("localhost");
		setUrl("jdbc:mysql://"+hostName+":"+port+"/"+dbName);
	}
	

	public MyConnectionInfo(String dbName, 
			String username, String password, String hostName, String port) {
		super();
		this.port = port;
		this.hostName = hostName;
		this.dbName = dbName;
		this.username = username;
		this.password = password;
		setUrl("jdbc:mysql://"+hostName+":"+port+"/"+dbName);
	}

	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
