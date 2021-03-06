package com.mobilerechargeapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionClass {
	
	public static Connection getConnection() 
	{
		
		Connection connection=null;
		
			try {
				Class.forName("oracle.jdbc.OracleDriver");
                String url="jdbc:oracle:thin:@localhost:1521:xe";
			   connection = DriverManager.getConnection(url,"system","oracle");
			} 
			catch (ClassNotFoundException e) 
			{
				
				e.getMessage();
	
			}catch(SQLException e) {
				e.getMessage();
			
			}
			return connection;
			 
		
}
	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet
			) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	
	
	
}