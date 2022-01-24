package com.mobilerechargeapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	public static Connection getConnection() 
	{
		Connection con=null;
		
			try {
				Class.forName("oracle.jdbc.OracleDriver");
                String url="jdbc:oracle:thin:@localhost:1521:xe";
			   con = DriverManager.getConnection(url,"system","oracle");
			} 
			catch (ClassNotFoundException e) 
			{
				
				e.getMessage();
				System.out.println("Driver jar doesn't there");
			}catch(SQLException e) {
				e.getMessage();
				System.out.println("url or username or password may wrong");
			}
			return con;
			 
		
}
}