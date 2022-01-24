package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapp.Dao.UserDao;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

public class UserDAOImpl implements UserDao {

	public boolean insertUser(User user) {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String subQue = "select * from operator_details where operator_name=?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(subQue);
			// System.out.println(user.getOperator().getOperatorname());
			pst.setString(1, user.getOperator().getOperatorname());

			
//			System.out.println(opId);
			String insertQuery = "insert into userlogin (user_name,Email_id,phone_number,password,operator_Id) values(?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(insertQuery);

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmailid());
			pstmt.setLong(3, user.getPhonenumber());
			pstmt.setString(4, user.getPassword());
		
			pstmt.setInt(5, user.getOperator().getOperatorId1());
			
//			System.out.println(user.getOperator().getOperatorname());
			flag = pstmt.executeUpdate() > 0;
//			System.out.println("value insterted successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	public User validiateUser(String Emailid, String password) {
		String Query = "select * from userlogin where Email_Id='" + Emailid + "' and password='" + password + "'";
		Connection con = ConnectionClass.getConnection();
		User user = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(Query);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			if (rst.next()) {
				// user = new User(rst.getString(2), Emailid, password);
				Operator operator = operatordao.findOperator1(rst.getInt(7));
				System.out.println(operator);
				user = new User(rst.getString(2), Emailid, rst.getLong(4), password, rst.getDouble(6), operator);
				user.setUserId(rst.getInt(1));
			} else {
				System.out.println("invalid user name and password");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("invalid Statement ");
		}
		return user;

	}

	public int findUserId(User user) {
		String findId = "select user_id from userlogin where Email_id='" + user.getEmailid() + "'";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(findId);
			if (rs.next()) {
				id = rs.getInt(1);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return id;

	}

	public User findUser(String emailId) {
		String Query = "select * from userlogin where Email_id='" + emailId + "'";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		Statement stmt = null;
		User user = null;
		OperatorDAOImpl operatordao = new OperatorDAOImpl();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			if (rs.next()) {
				Operator operator = operatordao.findOperator1(rs.getInt(7));
				user = new User(rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getDouble(6),
						operator);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;

	}

	public int updateuserWallet(User user) {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String Query = "update userlogin set wallet=? where Email_id=?";
		//String getWalletquery = "select wallet from userlogin where Email_id=?";
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			//pstmt = con.prepareStatement(getWalletquery);
			//pstmt.setString(1, user.getEmailid());
			//ResultSet rs = pstmt.executeQuery();
			//double wallet = 0;
			//if (rs.next()) {
			//	wallet = rs.getDouble(1);
			//}
			pstmt = con.prepareStatement(Query);
			pstmt.setDouble(1, user.getWallet());
			pstmt.setString(2, user.getEmailid());
			i = pstmt.executeUpdate();
			System.out.println(i + "updated");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return i;

	}

	public boolean rechargeWalletupdate(double planPrice, User user) {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String Query = "update userlogin set wallet=? where Email_id=?";
		String getWalletquery = "select wallet from userlogin where Email_id=?";
		PreparedStatement pstmt = null;
		boolean flag=false;
		try {
			pstmt = con.prepareStatement(getWalletquery);
			pstmt.setString(1, user.getEmailid());
			ResultSet rs = pstmt.executeQuery();
			double wallet = 0;
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
			pstmt = con.prepareStatement(Query);
			pstmt.setDouble(1, wallet - planPrice);
			pstmt.setString(2, user.getEmailid());
			flag = pstmt.executeUpdate()>0;
			//System.out.println(a + "wallet updated");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;

	}
	public User findUser(int userId) {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String Query="select * from userlogin where user_id='"+userId+"'";
		Statement stmt=null;
		User user=null;
		OperatorDAOImpl operatordao = new OperatorDAOImpl();
	
		try {
		ResultSet rs = stmt.executeQuery(Query);
			 stmt =con.createStatement();
			 
				if(rs.next()) {
				Operator operator = operatordao.findOperator1(rs.getInt(7));
				 user = new User(rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getDouble(6),
							operator);
				}
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return user;
		
	}
	public ResultSet history(int userId) {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String joinQuery = "select u.user_name,o.operator_name,h.plan_id,h.Recharge_date,h.Payment,h.mobile_number from userlogin u join operator_details o on u.operator_id=o.operator_id join  history_details h on h.user_id=u.user_id where h.user_id="+userId;
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(joinQuery);
			
//			System.out.println(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	

}
