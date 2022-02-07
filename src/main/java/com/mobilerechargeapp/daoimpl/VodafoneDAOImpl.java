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
	public boolean vodafoneNetwork(VodafoneUser vodafone) {
		boolean flag = false;
		Connection connection=ConnectionClass.getConnection();

		String insertQueries = "insert into vodafone_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
	int operatorId=vodafoneDao.operatorName(vodafone.getOperator().getOperatorname());
		try {
			
			preparedStatement = connection.prepareStatement(insertQueries);
			preparedStatement.setString(1, vodafone.getPlanName());
			preparedStatement.setDouble(2, vodafone.getPrice());
			preparedStatement.setString(3, vodafone.getValidity());
			preparedStatement.setString(4, vodafone.getBenfits());
			preparedStatement.setInt(5, operatorId);
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection,preparedStatement,resultSet);
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
	
	
	
	

	public boolean updateVodafone(String planName, Double price, String validity, String benefits, int vodafoneplanid) {
     	Connection connection=ConnectionClass.getConnection();
		String updateQuery = "update vodafone_plans set plan_name=?,price=?,validity=?,benefits=? where vodafoneplan_id =?";
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);

			preparedStatement.setString(1, planName);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, validity);
			preparedStatement.setString(4, benefits);
			preparedStatement.setInt(5, vodafoneplanid);
			resultSet = preparedStatement.executeQuery();
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}

	public boolean deleteVodafone(int vodafoneId) {
		String query = "select status from vodafone_plans where vodafoneplan_id =?";
		Connection connection=ConnectionClass.getConnection();
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String status = null;
		String deleteQuery = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, vodafoneId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				 status = resultSet.getString(1);
			}
			if (status != null && status.equalsIgnoreCase("Active")) {
				deleteQuery = "update vodafone_plans set status='inactive' where vodafoneplan_id =?";
			} else {
				deleteQuery = "update vodafone_plans set status='Active' where vodafoneplan_id =?";
			}
			preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, vodafoneId);
			flag=preparedStatement.executeUpdate()>0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}

	public int findvodafoneId(String planName, Double price) {
		String query = "select vodafoneplan_id from vodafone_plans where plan_name=? and price=?";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int vodafoneId = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, planName);
			preparedStatement.setDouble(2, price);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				vodafoneId = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return vodafoneId;

	}

	public List<VodafoneUser> showViplan() {
		VodafoneUser vodafone = new VodafoneUser();
		List<VodafoneUser> vodafoneList = new ArrayList<>();
		String showQuery = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id,status from vodafone_plans";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				vodafone = new VodafoneUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				vodafone.setVodafoneId(resultSet.getInt(1));
				vodafone.setStatus(resultSet.getString("status"));
				vodafoneList.add(vodafone);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return vodafoneList;
	}

	public List<VodafoneUser> showViplan(String search) {
		VodafoneUser vodafone = new VodafoneUser();
		List<VodafoneUser> vodafoneList = new ArrayList<>();
		String showQuery = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id from vodafone_plans where plan_name like '"
				+ search + "%' or price like '" + search + "%' and status='Active'";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				vodafone = new VodafoneUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				vodafone.setVodafoneId(resultSet.getInt(1));
				vodafone.setStatus(resultSet.getString("status"));
				vodafoneList.add(vodafone);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return vodafoneList;
	}

	public VodafoneUser findPlan(int id) {
		Connection connection=ConnectionClass.getConnection();
		VodafoneDAOImpl vodafoneDao = new VodafoneDAOImpl();
		int validity = 0;
	String query = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id from vodafone_plans where vodafoneplan_id=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		VodafoneUser plan = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				OperatorDAOImpl operDao = new OperatorDAOImpl();
				Operator operator = operDao.findOperator(resultSet.getInt(6));
				plan = new VodafoneUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
			
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return plan;

	}

	public int findVodafonevalidity(VodafoneUser vodafoneUser) {
		Connection connection=ConnectionClass.getConnection();
		VodafoneDAOImpl vodafoneDAOImpl = new VodafoneDAOImpl();
		int validity = 0;
		int vodafoneUserId = vodafoneDAOImpl.findvodafoneId(vodafoneUser.getPlanName(), vodafoneUser.getPrice());
		String query = "select validity from airtel_plans where airtelplan_id=?" + vodafoneUserId;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, vodafoneUserId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				validity = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return validity;

	}
	
	public List<VodafoneUser> showuserViplan() {
		VodafoneUser vodafone = new VodafoneUser();
		List<VodafoneUser> vodafoneList = new ArrayList<>();
		String showQuery = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id,status from vodafone_plans  where status='Active'";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				vodafone = new VodafoneUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				vodafone.setVodafoneId(resultSet.getInt(1));
				vodafone.setStatus(resultSet.getString("status"));
				vodafoneList.add(vodafone);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return vodafoneList;
	}

}
