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
    	Connection con=ConnectionClass.getConnection();
    	String insertQuery="select * from Admin where Admin_emailid='"+emailId+"' and password='"+password+"' ";
    	boolean flag=false;
    	try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(insertQuery);
			if(rs.next()) {
				//System.out.println(rs.getString(1));
				flag=true;
			}
			
		} catch (SQLException e) {
		System.out.println("query not excuted correctly");
			e.printStackTrace();
		}
    	
		return flag;
    	
    	
    }
}
