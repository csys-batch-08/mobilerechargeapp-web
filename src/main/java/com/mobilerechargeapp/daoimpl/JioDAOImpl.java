package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapp.Dao.JioDao;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

public class JioDAOImpl implements JioDao {
	public boolean insertJionet(JioUser jio) {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String insertQuery = "insert into jio_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, jio.getPlanName());
			pstmt.setDouble(2, jio.getPrice());
			pstmt.setString(3, jio.getValidity());
			pstmt.setString(4, jio.getBenfits());
//			pstmt.setInt(5, jio.getOperator().getOperatorId1());
			String subQuery = "select * from operator_details where operator_name=?";
			PreparedStatement pst = con.prepareStatement(subQuery);
			pst.setString(1, jio.getOperator().getOperatorname());
			ResultSet rs = pst.executeQuery();
			int opId = 0;
			if (rs.next()) {
				opId = rs.getInt(1);
			}
			System.out.println(opId);
			pstmt.setInt(5, opId);
			flag = pstmt.executeUpdate() > 0;
//			ResultSet r=pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("insert Query will in correct");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateJio(String planName1, Double price1, String validity1, String benefits1, int jioplanId) {
		String updateQuery = "update jio_plans set plan_name=?,price=?,validity=?,benefits=? where jioplan_id=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, planName1);
			pstmt.setDouble(2, price1);
			pstmt.setString(3, validity1);
			pstmt.setString(4, benefits1);
			pstmt.setInt(5, jioplanId);
			flag = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Update Query will incorrect");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteJio(int jioplanId) {

		String deleteQuery = "delete from jio_plans where jioplan_id=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(deleteQuery);

			pstmt.setInt(1, jioplanId);
			flag = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
//			System.out.println(" Query will be error");
			e.printStackTrace();
		}
		return flag;
	}

	public List<JioUser> showJioplan() {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<JioUser>();
		String showQuery = "select * from jio_plans";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (rs.next()) {

				Operator operator = operatordao.findOperator1(rs.getInt(6));

//			System.out.println(operator);
				jio = new JioUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), operator);
				jioList.add(jio);
			}
		} catch (SQLException e) {
			System.out.println("invalid");
			e.printStackTrace();
		}
		return jioList;
	}
	
	
	public int findjioId(String planName, Double price) {
		String query = "select jioplan_id from jio_plans where plan_name=? and price=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		PreparedStatement pstmt;
		int jioplanId = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				jioplanId = rs.getInt(1);
				return jioplanId;
			}
		} catch (SQLException e) {
			System.out.println("invalid_id");
			e.printStackTrace();
		}

		return jioplanId;

	}

	public int findJiovalidity(JioUser jioUser) {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		JioDAOImpl jioDao = new JioDAOImpl();
		int validity=0;
		int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
		String Query = "select validity from jio_plans where jioplan_id=" + JioUserId;
		ResultSet rs = null;
		try {

			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(Query);
			if(rs.next())
			{
				validity=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return validity;

	}
	
	
	public List<JioUser> showJioplan1() {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<JioUser>();
		String showQuery = "select * from jio_plans order by price asc ";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (rs.next()) {

				Operator operator = operatordao.findOperator1(rs.getInt(6));


				jio = new JioUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), operator);
				jioList.add(jio);
			}
		} catch (SQLException e) {
			System.out.println("invalid");
			e.printStackTrace();
		}
		return jioList;
	}
	public JioUser findPlan(int id)
	{
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		JioDAOImpl jioDao = new JioDAOImpl();
		int validity=0;
		//int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
		String Query = "select * from jio_plans where jioplan_id=" + id;
		ResultSet rs = null;
		JioUser plan=null;
		try {

			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(Query);
			if(rs.next())
			{
				OperatorDAOImpl operDao=new OperatorDAOImpl();
				Operator operator=operDao.findOperator(rs.getInt(6));
				plan=new JioUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),operator );
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return plan;
		
	}
	public List<JioUser> showJioplan(String search) {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<JioUser>();
		String showQuery = "select * from jio_plans where plan_name like '"+search+"%' or price like '"+search+"%'";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (rs.next()) {

				Operator operator = operatordao.findOperator1(rs.getInt(6));

//			System.out.println(operator);
				jio = new JioUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), operator);
				jioList.add(jio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jioList;
	}
	
	
	
	

	
	

}
