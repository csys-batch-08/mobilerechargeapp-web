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
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String insertQuery = "insert into userlogin (user_name,Email_id,phone_number,password,operator_Id) values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmailid());
			preparedStatement.setLong(3, user.getPhonenumber());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getOperator().getOperatorId1());
			flag = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, null);
		}
		return flag;
	}
	
	public int operatorName(String opertorName) {
		Connection connection=ConnectionClass.getConnection();
		String subQuery = "select operator_id,operator_name from operator_details where operator_name=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int opId = 0;
		try {
			preparedStatement = connection.prepareStatement(subQuery);
			preparedStatement.setString(1,opertorName);
			resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			opId = resultSet.getInt(1);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return opId;
		
	}

	public User validiateUser(String emailid, String password) {
		String query = "select user_id,user_name,Email_id,phone_number,password,wallet,operator_id from userlogin where Email_id=? and password=?";
		Connection connection = ConnectionClass.getConnection();
		User user = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailid);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			if (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(7));

				user = new User(resultSet.getString(2), emailid, resultSet.getLong(4), password, resultSet.getDouble(6),
						operator);
				user.setUserId(resultSet.getInt(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return user;

	}

	public int findUserId(User user) {
		String findId = "select user_id from userlogin where Email_id='" + user.getEmailid() + "'";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int id = 0;
		try {
			preparedStatement=connection.prepareStatement(findId);

			resultSet=preparedStatement.executeQuery();
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
		String query = "select user_id,user_name,Email_id,phone_number,password,wallet,operator_id from userlogin where Email_id=?";
		Connection connection=ConnectionClass.getConnection();
		User user = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		OperatorDAOImpl operatordao = new OperatorDAOImpl();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(7));
				user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
						resultSet.getString(5), resultSet.getDouble(6), operator);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return user;

	}

	public int updateuserWallet(User user) {
		Connection connection=ConnectionClass.getConnection();
		String query = "update userlogin set wallet=? where Email_id=?";
        PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int i = 0;
		try {

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, user.getWallet());

			preparedStatement.setString(2, user.getEmailid());
			resultSet = preparedStatement.executeQuery();
			i = preparedStatement.executeUpdate();
			user.setWallet(user.getWallet());

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return i;

	}

	public boolean rechargeWalletupdate(double planPrice, User user) {
		Connection connection=ConnectionClass.getConnection();
		String query = "update userlogin set wallet=? where Email_id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		UserDAOImpl userDao=new UserDAOImpl();
Double wallet=userDao.wallet(user);
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, wallet - planPrice);

			preparedStatement.setString(2, user.getEmailid());
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}
	
	public double  wallet(User user) {
		Connection connection=ConnectionClass.getConnection();
		String getWalletquery = "select wallet from userlogin where Email_id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		double	walletamount=0;
		try {
			preparedStatement = connection.prepareStatement(getWalletquery);
			preparedStatement.setString(1, user.getEmailid());
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				walletamount = resultSet.getDouble(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		
		return walletamount;	
	}
	
	

	public User findUser(int userId) {
		Connection connection=ConnectionClass.getConnection();
		String query = "select user_id,user_name,Email_id,phone_number,password,wallet,operator_id from userlogin where user_id=?"
				+ userId;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		OperatorDAOImpl operatordao = new OperatorDAOImpl();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(7));
				user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
						resultSet.getString(5), resultSet.getDouble(6), operator);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return user;

	}

	public List<Object> history(int userId) {
		Connection connection=ConnectionClass.getConnection();
		String joinQuery = "select o.operator_name,h.mobile_number,h.plan_id,h.Recharge_date,h.Payment from "
				+ "operator_details o join history_details h on o.operator_id=h.operator_id where h.user_id=?";
		ResultSet resultSet = null;
		List<Object> list = null;
		List<Object> listObject = null;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(joinQuery);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			listObject = new ArrayList<>();
			while (resultSet.next()) {
				list = new ArrayList<>();

				list.add(resultSet.getString("operator_name"));
				list.add(resultSet.getLong("mobile_number"));
				list.add(resultSet.getInt("plan_id"));
				list.add(resultSet.getDate("Recharge_date"));
				list.add(resultSet.getDouble("Payment"));
				listObject.add(list);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return listObject;
	}
	
	public String emailValid( String emailid)
 {
	String email=null;
		ResultSet resultSet = null;
		Connection connection=ConnectionClass.getConnection();
	   PreparedStatement preparedStatement = null;
		try {
			String query = "select Email_id from userlogin where Email_id =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,emailid);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
			 email=resultSet.getString(1);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		} 
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return email;

	}
	
	
	public int forgetPasssword(String emailid, String password) {
		Connection connection=ConnectionClass.getConnection();
		String query="update userlogin set password=? where Email_id=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
	int passwords=0;
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,password );
			preparedStatement.setString(2,emailid) ;
			passwords=preparedStatement.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return passwords;
	}
}
