package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapp.Dao.HistorydetailsDao;
import com.mobilerechargeapp.model.HistoryDetails;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

public class HistorydetailsDAOImpl implements HistorydetailsDao {
       public boolean insertDetails(HistoryDetails historyDetails) {
    	   boolean flag=false;
   		ConnectionClass connectionClass = new ConnectionClass();
   		Connection connection = connectionClass.getConnection();
   		
  		String insertQuery="insert into  history_details (user_id,mobile_number,operator_id,plan_id,Recharge_date,Payment)values(?,?,?,?,?,?)";
  		PreparedStatement preparedStatement=null;
  		ResultSet resultSet=null;
   		try {
			preparedStatement=connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1,  historyDetails.getUserId());
			preparedStatement.setLong(2, historyDetails.getMobileNumber());
		    preparedStatement.setInt(3,historyDetails.getOperatorId());
			preparedStatement.setInt(4,historyDetails.getPlanId());
			//pstmt.setDate(4,(Date) historyDetails.getRechargeDate());
	        preparedStatement.setDate(5,new java.sql.Date(historyDetails.getRechargeDate().getTime()));	    
	       	preparedStatement.setDouble(6,historyDetails.getWallet());
			flag=preparedStatement.executeUpdate()>0;
   			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
   		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	
           }
       public List<HistoryDetails> showHistoryDetails()
       {
    	   List<HistoryDetails> historyList=new ArrayList<HistoryDetails>();
    	   String query="select history_id,user_id,operator_id,mobile_number,plan_id,Recharge_date,Payment  from history_details";
    	   Connection con=ConnectionClass.getConnection();
    	   try
    	   {
    	   Statement stmt=con.createStatement();
    	   ResultSet rs=stmt.executeQuery(query);
    	   while(rs.next())
    	   {
    		   HistoryDetails his=new HistoryDetails(rs.getInt(2),rs.getInt(3), rs.getLong(4), rs.getInt(5), rs.getDate(6), rs.getDouble(7));
    		   historyList.add(his);
    	   }
    	   
    	   }
    	   catch(Exception e)
    	   {
    		   e.printStackTrace();
    	   }
    	   
    	   return historyList;
    	   
       }

	public List<HistoryDetails> findUserHistory(User user)
	{
		UserDAOImpl userDao=new UserDAOImpl();
		List<HistoryDetails> userHistoryList=new ArrayList<HistoryDetails>();
		
		List<HistoryDetails> historyList=showHistoryDetails();
		int userId=userDao.findUserId(user);
		System.out.println(userId);
		for(int i=0;i<historyList.size();i++)
		{
			if(historyList.get(i).getUserId()==userId)
			{
				userHistoryList.add(historyList.get(i));
				System.out.println(historyList);
			}
			
		}
		
		return userHistoryList;
	}
	
	
	public List<HistoryDetails> findUserHis(User user)
	{
		UserDAOImpl userDao=new UserDAOImpl();
		List<HistoryDetails> userHistoryList=new ArrayList<HistoryDetails>();
		String query="select history_id,user_id,operator_id,mobile_number,plan_id,Recharge_date,Payment from history_details";
		Connection con=ConnectionClass.getConnection();
 	   try
 	   {
 	   Statement stmt=con.createStatement();
 	   ResultSet rs=stmt.executeQuery(query);
 	   while(rs.next())
	
 	  {
		   HistoryDetails his=new HistoryDetails(rs.getInt(2),rs.getInt(3), rs.getLong(4), rs.getInt(5), rs.getDate(6), rs.getDouble(7));
		   userHistoryList.add(his);
	   }
	   
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return userHistoryList;
	   
   }
	
	
	
}


