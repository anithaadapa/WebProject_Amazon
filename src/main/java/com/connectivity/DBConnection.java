package com.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	

	public Connection connection;
	
	//3 methods to Database connection,get connection, closeconnection
	
	//Method 1 to create DB connection
	public DBConnection(String dbURL,String user,String pwd) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, user,pwd);
		
	}
	
	//Method to get the connection # Method
	
	public Connection getConnection() {
		
		return this.connection;
		
	}
	
	//Method to close the connection
	
	public void closeConnection() throws SQLException {
		
		if(this.connection!=null)
		{
			this.connection.close();
		}
		
	}
	
	
	
	
	
	

}
