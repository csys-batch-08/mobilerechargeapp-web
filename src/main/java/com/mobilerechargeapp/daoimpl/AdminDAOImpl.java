package com.mobilerechargeapp.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapp.Dao.AdminDao;
import com.mobilerechargeapp.model.Admin;
import com.mobilerechargeapp.util.ConnectionClass;

public class AdminDAOImpl implements AdminDao {
    public boolean validateAdmin(String emailId,String password)
    {
    	Connection connection=ConnectionClass.getConnection();
    	String insertQuery="select admin_emailid,password from Admin where Admin_emailid='"+emailId+"' and password='"+password+"' ";
    	boolean flag=false;
    	PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
    	try {
    		preparedStatement=connection.prepareStatement(insertQuery);
    		resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				
				flag=true;
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    	 finally {
 			ConnectionClass.close(connection, preparedStatement, resultSet);
 		}
		return flag;
    	
    	
    }
}
