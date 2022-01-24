package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapp.Dao.VodafoneDao;
import com.mobilerechargeapp.model.AirtelUser;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.model.VodafoneUser;
import com.mobilerechargeapp.util.ConnectionClass;

public class VodafoneDAOImpl implements VodafoneDao {
	public boolean vodafoneNetwork(VodafoneUser vodafone)  {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();

		String subQueries = "select * from operator_details where operator_name=?";
		String insertQueries = "insert into vodafone_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		try {
		PreparedStatement psmt = con.prepareStatement(subQueries);
		psmt.setString(1, vodafone.getOperator().getOperatorname());
		ResultSet rs = psmt.executeQuery();
		int opId = 0;
		if (rs.next()) {
			opId = rs.getInt(1);
		}

		
			PreparedStatement pstmt = con.prepareStatement(insertQueries);
			pstmt.setString(1, vodafone.getPlanName());
			pstmt.setDouble(2, vodafone.getPrice());
			pstmt.setString(3, vodafone.getValidity());
			pstmt.setString(4, vodafone.getBenfits());
			pstmt.setInt(5, opId);
			flag=pstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query will incorrect");
		}
		return flag;
	}

	public boolean updateVodafone( String planName, Double price, String validity, String benefits,int vodafoneplanid) {

		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String updateQuery = "update vodafone_plans set plan_name=?,price=?,validity=?,benefits=? where vodafoneplan_id =?";
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(updateQuery);
		
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			pstmt.setString(3, validity);
			pstmt.setString(4, benefits);
			pstmt.setInt(5, vodafoneplanid);
		flag=pstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.out.println("updated Query will incorrect");
			e.printStackTrace();
		}

		return flag;

	}

	public boolean deleteVodafone(int vodafoneId) {

		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String deleteQuery = "delete vodafone_plans where vodafoneplan_id =?";
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1,vodafoneId);
		flag=pstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
		System.out.println("Delete Query will in correct");
			e.printStackTrace();
		}

		return flag;

	}

	public int findvodafoneId(String planName, Double price) {
		String query = "select vodafoneplan_id from vodafone_plans where plan_name=? and price=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		PreparedStatement pstmt;
		int vodafoneId = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vodafoneId = rs.getInt(1);
			}
		} catch (SQLException e) {
            System.out.println("Query will incorrect");
			e.printStackTrace();
		}

		return vodafoneId;

	}

	public List<VodafoneUser> showViplan() {
		VodafoneUser vodafone = new VodafoneUser();
		List<VodafoneUser> vodafoneList = new ArrayList<VodafoneUser>();
		String showQuery = "select * from vodafone_plans";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (rs.next()) {
				Operator operator = operatordao.findOperator1(rs.getInt(6));
				vodafone = new VodafoneUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),
						operator);
				vodafoneList.add(vodafone);
			}
		} catch (SQLException e) {
           System.out.println("Query will incorrect");
			e.printStackTrace();
		}
		return vodafoneList;
	}
	
	
	
	public List<VodafoneUser> showViplan(String search) {
		VodafoneUser vodafone = new VodafoneUser();
		List<VodafoneUser> vodafoneList = new ArrayList<VodafoneUser>();
		String showQuery = "select * from vodafone_plans where plan_name like '"+search+"%' or price like '"+search+"%'";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (rs.next()) {
				Operator operator = operatordao.findOperator1(rs.getInt(6));
				vodafone = new VodafoneUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),
						operator);
				vodafoneList.add(vodafone);
			}
		} catch (SQLException e) {
           System.out.println("Query will incorrect");
			e.printStackTrace();
		}
		return vodafoneList;
	}
	
	
	public ResultSet  findVodafonevalidity() {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		VodafoneUser vodafoneUser=new VodafoneUser();
		int VodafoneUserId=vodafoneDao.findvodafoneId(vodafoneUser.getPlanName(),vodafoneUser.getPrice());
		String Query = "select validity from jio_plans where jioplan_id="+VodafoneUserId;
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
	public VodafoneUser findPlan(int id)
	{
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		int validity=0;
		//int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
		String Query = "select * from vodafone_plans where vodafoneplan_id=" + id;
		ResultSet rs = null;
	VodafoneUser plan=null;
		try {

			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(Query);
			if(rs.next())
			{
				OperatorDAOImpl operDao=new OperatorDAOImpl();
				Operator operator=operDao.findOperator(rs.getInt(6));
				plan=new VodafoneUser  (rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),operator );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plan;
		
	}

}
