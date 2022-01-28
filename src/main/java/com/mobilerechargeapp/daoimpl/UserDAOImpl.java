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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		String subQue = "select operator_id,operator_name from operator_details where operator_name=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(subQue);
			// System.out.println(user.getOperator().getOperatorname());
			preparedStatement.setString(1, user.getOperator().getOperatorname());
			String insertQuery = "insert into userlogin (user_name,Email_id,phone_number,password,operator_Id) values(?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmailid());
			preparedStatement.setLong(3, user.getPhonenumber());
			preparedStatement.setString(4, user.getPassword());

			preparedStatement.setInt(5, user.getOperator().getOperatorId1());

//			System.out.println(user.getOperator().getOperatorname());
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;

	}

	public User validiateUser(String Emailid, String password) {
		String Query = "select user_id,user_name,Email_id,phone_number,password,wallet,operator_id from userlogin where Email_id=? and password=?";
		Connection connection = ConnectionClass.getConnection();
		User user = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setString(1, Emailid);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			if (resultSet.next()) {
				// user = new User(rst.getString(2), Emailid, password);
				Operator operator = operatordao.findOperator1(resultSet.getInt(7));
				System.out.println(operator);
				user = new User(resultSet.getString(2), Emailid, resultSet.getLong(4), password, resultSet.getDouble(6),
						operator);
				user.setUserId(resultSet.getInt(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("invalid Statement ");
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return user;

	}

	public int findUserId(User user) {
//		String findId = "select user_id from userlogin where Email_id='" + user.getEmailid() + "'";
		String findId = "select user_id from userlogin where Email_id=?" ;
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int id = 0;
		try {
			preparedStatement=connection.prepareStatement(findId);
			preparedStatement.setString(1, user.getEmailid());
			resultSet=preparedStatement.executeQuery();
//			stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(findId);
			if (resultSet.next()) {
				id = resultSet.getInt(1);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return id;

	}

	public User findUser(String emailId) {
		String Query = "select user_id,user_name,Email_id,phone_number,password,wallet,operator_id from userlogin where Email_id=?";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		User user = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		OperatorDAOImpl operatordao = new OperatorDAOImpl();
		try {
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(7));
				user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
						resultSet.getString(5), resultSet.getDouble(6), operator);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return user;

	}

	public int updateuserWallet(User user) {
		ConnectionClass connectionClass  = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		String Query = "update userlogin set wallet=? where Email_id=?";
		// String getWalletquery = "select wallet from userlogin where Email_id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		int i = 0;
		try {
			// pstmt = con.prepareStatement(getWalletquery);
			// pstmt.setString(1, user.getEmailid());
			// ResultSet rs = pstmt.executeQuery();
			// double wallet = 0;
			// if (rs.next()) {
			// wallet = rs.getDouble(1);
			// }
		    preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setDouble(1, user.getWallet());
			preparedStatement.setString(2, user.getEmailid());
			resultSet=preparedStatement.executeQuery();
			i = preparedStatement.executeUpdate();
			System.out.println(i + "updated");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return i;

	}

	public boolean rechargeWalletupdate(double planPrice, User user) {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		String Query = "update userlogin set wallet=? where Email_id=?";
		String getWalletquery = "select wallet from userlogin where Email_id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		boolean flag = false;
		try {
	      	preparedStatement = connection.prepareStatement(getWalletquery);
			preparedStatement.setString(1, user.getEmailid());
			ResultSet rs = preparedStatement.executeQuery();
			double wallet = 0;
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setDouble(1, wallet - planPrice);
			preparedStatement.setString(2, user.getEmailid());
			flag =preparedStatement.executeUpdate() > 0;
			// System.out.println(a + "wallet updated");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}

	public User findUser(int userId) {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
//		String Query = "select user_id,user_name,Email_id,phone_number,password,wallet,operator_id from userlogin where user_id='"
//				+ userId + "'";
//		Statement stmt=null;
		String Query = "select user_id,user_name,Email_id,phone_number,password,wallet,operator_id from userlogin where user_id=?"
				+ userId ;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		OperatorDAOImpl operatordao = new OperatorDAOImpl();

		try {
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
//		   ResultSet rs = stmt.executeQuery(Query);
//			 stmt =con.createStatement();

			if (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(7));
				user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
						resultSet.getString(5), resultSet.getDouble(6), operator);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return user;

	}

	public ResultSet history(int userId) {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String joinQuery = "select u.user_name,o.operator_name,h.plan_id,h.Recharge_date,h.Payment,h.mobile_number from userlogin u join operator_details o on u.operator_id=o.operator_id join  history_details h on h.user_id=u.user_id where h.user_id="
				+ userId;
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
