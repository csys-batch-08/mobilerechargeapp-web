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

import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;

import com.mobilerechargeapp.util.ConnectionClass;

public class AirtelDAOImpl implements AirtelDao {
	public boolean insertAirtelnet(AirtelUser airtel) {
		boolean flag = false;
		Connection connection = ConnectionClass.getConnection();
		String insertQue = "insert into Airtel_plans (plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		AirtelDAOImpl airtelDao = new AirtelDAOImpl();
		int operatorId = airtelDao.operatorName(airtel.getOperator().getOperatorname());
		try {
			preparedStatement = connection.prepareStatement(insertQue);
			preparedStatement.setString(1, airtel.getPlanName());
			preparedStatement.setDouble(2, airtel.getPrice());
			preparedStatement.setString(3, airtel.getValidity());
			preparedStatement.setString(4, airtel.getBenfits());
			preparedStatement.setInt(5, operatorId);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public int operatorName(String opertorName) {
		Connection connection = ConnectionClass.getConnection();
		String subQuery = "select operator_id,operator_name from operator_details where operator_name=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int opId = 0;
		try {
			preparedStatement = connection.prepareStatement(subQuery);
			preparedStatement.setString(1, opertorName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				opId = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return opId;
	}

	int airtelplanId = 0;

	public boolean updateAirtel(String planname, Double price, String validity, String benefits, int airtelplanId) {
		boolean flag = false;
		Connection connection = ConnectionClass.getConnection();
		String updateQuery = "update  Airtel_plans set plan_name=?,price=?,validity=?,benefits=? where airtelplan_id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, planname);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, validity);
			preparedStatement.setString(4, benefits);
			preparedStatement.setInt(5, airtelplanId);
			resultSet = preparedStatement.executeQuery();
			flag = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public boolean deleteAirtel(int airtelplanId) {
		boolean flag = false;
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String deleteQuery = null;
		AirtelDAOImpl airtelDao = new AirtelDAOImpl();
		String status = airtelDao.getStatus(airtelplanId);
		try {
			if (status != null && status.equalsIgnoreCase("active")) {
				deleteQuery = "update Airtel_plans set status='inactive'where airtelplan_id=?";
			} else {
				deleteQuery = "update Airtel_plans set status='Active' where airtelplan_id=?";
			}
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, airtelplanId);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {

		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public String getStatus(int airtelplanId) {
		String query = "select status from Airtel_plans  where airtelplan_id=?";
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String status = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, airtelplanId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				status = resultSet.getString(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return status;
	}

	public List<AirtelUser> showAirtelplan() {
		AirtelUser airtel = null;
		List<AirtelUser> airtelList = new ArrayList<>();
		String showQuery = "select airtelplan_id,plan_name,price,validity,benefits,operator_id,status from Airtel_plans";
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);

			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				airtel = new AirtelUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				airtel.setAirtelId(resultSet.getInt(1));
				airtel.setStatus(resultSet.getString(7));
				airtelList.add(airtel);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return airtelList;
	}

	public List<AirtelUser> showAirtelplan(String search) {
		AirtelUser airtel = null;
		List<AirtelUser> airtelList = new ArrayList<>();
		String showQuery = "select airtelplan_id ,plan_name,price,validity,benefits,operator_id,status from  Airtel_plans where status='Active' and plan_name like ? or price like ?";
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			preparedStatement.setString(1, "%" + search.toLowerCase() + "%");
			preparedStatement.setString(2, "%" + search.toLowerCase() + "%");
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				airtel = new AirtelUser(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getString(4), resultSet.getString(5), operator);
				airtelList.add(airtel);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return airtelList;
	}

	public int findairtelId(String planName, Double price) {
		String query = "select airtelplan_id from Airtel_plans where plan_name=? and price=?";
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int airtelplanId1 = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, planName);
			preparedStatement.setDouble(2, price);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				airtelplanId1 = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return airtelplanId1;
	}

	public AirtelUser findPlan(int id) {
		Connection connection = ConnectionClass.getConnection();
		AirtelDAOImpl airtelDao = new AirtelDAOImpl();
		int validity = 0;
		String query = "select airtelplan_id,plan_name,price,validity,benefits,operator_id from Airtel_plans where airtelplan_id=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		AirtelUser plan = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				OperatorDAOImpl operDao = new OperatorDAOImpl();
				Operator operator = operDao.findOperator(resultSet.getInt(6));
				plan = new AirtelUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return plan;
	}

	public List<AirtelUser> searchAirtelplan(String plan) {
		AirtelUser airtel = null;
		List<AirtelUser> airtelList = new ArrayList<>();
		String showQuery = "select airtelplan_id,plan_name,price,validity,benefits,operator_id,status from Airtel_plans where upper (PLAN_NAME)like'"
				+ plan.toUpperCase() + "%' and status='Active'";
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery(showQuery);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				airtel = new AirtelUser(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getString(4), resultSet.getString(5), operator);
				airtel.setStatus(resultSet.getString("status"));
				airtelList.add(airtel);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return airtelList;
	}

	public int findAirtelvalidity(AirtelUser airtelUser) {
		Connection connection = ConnectionClass.getConnection();
		AirtelDAOImpl airtelDAOImpl = new AirtelDAOImpl();
		int validity = 0;
		int airtelUserId = airtelDAOImpl.findairtelId(airtelUser.getPlanName(), airtelUser.getPrice());
		String query = "select validity from airtel_plans where airtelplan_id=?" + airtelUserId;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, airtelUserId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				validity = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return validity;
	}

	public List<AirtelUser> showUserAirtelplan() {
		AirtelUser airtel = null;
		List<AirtelUser> airtelList = new ArrayList<>();
		String showQuery = "select airtelplan_id,plan_name,price,validity,benefits,operator_id,status from Airtel_plans where status='Active'";
		Connection connection = ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				airtel = new AirtelUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				airtel.setAirtelId(resultSet.getInt(1));
				airtel.setStatus(resultSet.getString("status"));
				airtelList.add(airtel);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return airtelList;
	}
}
