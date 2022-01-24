package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapp.Dao.AirtelDao;
import com.mobilerechargeapp.model.AirtelUser;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.model.VodafoneUser;
import com.mobilerechargeapp.util.ConnectionClass;

public class AirtelDAOImpl implements AirtelDao {
  public boolean insertAirtelnet(AirtelUser airtel)  {
	  boolean flag=false;
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String subQuery="select * from operator_details where operator_name=?";
	  try {
	  PreparedStatement pst=con.prepareStatement(subQuery);
	  pst.setString(1,airtel.getOperator().getOperatorname());
      ResultSet rs=pst.executeQuery();
      int opId=0;
	   if( rs.next()){
	    opId=rs.getInt(1);
	   }
	   String insertQue="insert into Airtel_plans (plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
	
		PreparedStatement pstmt=con.prepareStatement(insertQue);
		pstmt.setString(1,airtel.getPlanName() );
		pstmt.setDouble(2, airtel.getPrice());
		pstmt.setString(3,airtel.getValidity());
		pstmt.setString(4,airtel.getBenfits());
		pstmt.setInt(5,opId);
		
       flag=pstmt.executeUpdate()>0;   

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return flag;
  }
  int airtelplanId = 0;
  public boolean updateAirtel(String planname, Double price, String validity, String benefits,int airtelplanId) {
	  
	  boolean flag=false;
	 
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String updateQuery="update  Airtel_plans set plan_name=?,price=?,validity=?,benefits=? where airtelplan_id=?";
      PreparedStatement pstmt=null;
      try {
		pstmt=con.prepareStatement(updateQuery);
		
		pstmt.setString(1, planname);
		pstmt.setDouble(2,price);
		pstmt.setString(3,validity);
		pstmt.setString(4,benefits);
		pstmt.setInt(5,airtelplanId);
		
	flag=pstmt.executeUpdate()>0;
		
		
	} 
      catch (SQLException e) {
		System.out.println("updated not properly");
		e.printStackTrace();
	}
	return flag;
	}

  public boolean deleteAirtel(int airtelplanId) {
	  boolean flag=false;
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String deleteQuerey="delete from Airtel_plans where airtelplan_id=?";
	  PreparedStatement pstmt=null;
	  try {
		pstmt=con.prepareStatement(deleteQuerey);
		pstmt.setInt(1,airtelplanId);
	    flag=pstmt.executeUpdate()>0;
	
	} catch (SQLException e) {
		System.out.println("deleted not properly");
	}
	return flag;
	  
  }
  public List<AirtelUser>showAirtelplan()
	{
		AirtelUser airtel=null;
		List<AirtelUser> AirtelList=new ArrayList<AirtelUser>();
		String showQuery="select * from Airtel_plans";
		ConnectionClass conclass=new ConnectionClass();
		Connection con=conclass.getConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao=new OperatorDAOImpl();
			while(rs.next()) {
				Operator operator=operatordao.findOperator1(rs.getInt(6));
				 airtel=new AirtelUser(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),operator);
				 AirtelList.add(airtel);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return AirtelList;
		}
  
  
  public List<AirtelUser>showAirtelplan(String search)
	{
		AirtelUser airtel=null;
		List<AirtelUser> AirtelList=new ArrayList<AirtelUser>();
		String showQuery="select * from Airtel_plans where plan_name like '"+search+"%' or price like '"+search+"%'";
		ConnectionClass conclass=new ConnectionClass();
		Connection con=conclass.getConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao=new OperatorDAOImpl();
			while(rs.next()) {
				Operator operator=operatordao.findOperator1(rs.getInt(6));
				 airtel=new AirtelUser(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),operator);
				 AirtelList.add(airtel);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return AirtelList;
		}
  
  
  
  public  int  findairtelId(String planName,Double price) {
		String query="select airtelplan_id from Airtel_plans where plan_name=? and price=?"; 
		ConnectionClass conclass=new ConnectionClass();
		Connection con = conclass.getConnection();
		PreparedStatement pstmt;
		int airtelplanId=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				airtelplanId=rs.getInt(1);
			}
			}
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return airtelplanId;
		
	}
  public ResultSet  findAirtelvalidity() {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		AirtelDAOImpl airtelDao=new AirtelDAOImpl();
		AirtelUser airtelUser=new AirtelUser();
		int AirtelUserId = 0;
		try {
			AirtelUserId = airtelDao.findairtelId(airtelUser.getPlanName(),airtelUser.getPrice());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String Query = "select validity from jio_plans where jioplan_id="+AirtelUserId;
		ResultSet rs=null;
		try {
			
			Statement stmt=con.createStatement();
		     rs = stmt.executeQuery(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
  public AirtelUser findPlan(int id)
	{
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		AirtelDAOImpl airtelDao=new AirtelDAOImpl();
		int validity=0;
		//int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
		String Query = "select * from Airtel_plans where airtelplan_id=" + id;
		ResultSet rs = null;
	    AirtelUser plan=null;
		try {

			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(Query);
			if(rs.next())
			{
				OperatorDAOImpl operDao=new OperatorDAOImpl();
				Operator operator=operDao.findOperator(rs.getInt(6));
				plan=new AirtelUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),operator );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plan;
		
	}
  public List<AirtelUser>searchAirtelplan(String plan)
 	{
 		AirtelUser airtel=null;
 		List<AirtelUser> AirtelList=new ArrayList<AirtelUser>();
 		String showQuery="select * from Airtel_plans  where upper (PLAN_NAME)like'" +plan.toUpperCase()+"%'";
 		ConnectionClass conclass=new ConnectionClass();
 		Connection con=conclass.getConnection();
 		try {
 			Statement stmt=con.createStatement();
 			ResultSet rs=stmt.executeQuery(showQuery);
 			OperatorDAOImpl operatordao=new OperatorDAOImpl();
 			while(rs.next()) {
 				Operator operator=operatordao.findOperator1(rs.getInt(6));
 				 airtel=new AirtelUser(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),operator);
 				 AirtelList.add(airtel);
 			}
 		} catch (SQLException e) {
 			
 			e.printStackTrace();
 		}
 		return AirtelList;
 		}
}
