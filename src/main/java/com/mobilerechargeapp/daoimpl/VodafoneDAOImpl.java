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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();

		String subQueries = "select operator_id,operator_name from operator_details where operator_name=?";
		String insertQueries = "insert into vodafone_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(insertQueries);
			preparedStatement.setString(1, vodafone.getPlanName());
			preparedStatement.setDouble(2, vodafone.getPrice());
			preparedStatement.setString(3, vodafone.getValidity());
			preparedStatement.setString(4, vodafone.getBenfits());

			PreparedStatement preparedStatement1 = connection.prepareStatement(subQueries);
			preparedStatement1.setString(1, vodafone.getOperator().getOperatorname());
			resultSet = preparedStatement1.executeQuery();
			int opId = 0;
			if (resultSet.next()) {
				opId = resultSet.getInt(1);
			}
			preparedStatement.setInt(5, opId);
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query will incorrect");
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public boolean updateVodafone(String planName, Double price, String validity, String benefits, int vodafoneplanid) {

		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
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
			System.out.println("updated Query will incorrect");
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}

	public boolean deleteVodafone(int vodafoneId) {

		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		String deleteQuery = "delete vodafone_plans where vodafoneplan_id =?";
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, vodafoneId);
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}

	public int findvodafoneId(String planName, Double price) {
		String query = "select vodafoneplan_id from vodafone_plans where plan_name=? and price=?";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
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
		List<VodafoneUser> vodafoneList = new ArrayList<VodafoneUser>();
		String showQuery = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id from vodafone_plans";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
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
		List<VodafoneUser> vodafoneList = new ArrayList<VodafoneUser>();
		String showQuery = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id from vodafone_plans where plan_name like '"
				+ search + "%' or price like '" + search + "%'";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		VodafoneDAOImpl vodafoneDao = new VodafoneDAOImpl();
		int validity = 0;
		// int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
//		String Query = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id from vodafone_plans where vodafoneplan_id=" + id;
		String Query = "select vodafoneplan_id,plan_name,price,validity,benefits,operator_id from vodafone_plans where vodafoneplan_id=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		VodafoneUser plan = null;
		try {
			preparedStatement = connection.prepareStatement(Query);
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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		VodafoneDAOImpl vodafoneDAOImpl = new VodafoneDAOImpl();
		int validity = 0;
		int VodafoneUserId = vodafoneDAOImpl.findvodafoneId(vodafoneUser.getPlanName(), vodafoneUser.getPrice());
		String Query = "select validity from airtel_plans where airtelplan_id=?" + VodafoneUserId;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query);
			preparedStatement.setInt(1, VodafoneUserId);
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

}
