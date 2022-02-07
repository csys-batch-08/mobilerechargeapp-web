package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapp.Dao.BsnlDao;
import com.mobilerechargeapp.model.AirtelUser;
import com.mobilerechargeapp.model.BsnlUser;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

public class BsnlDAOImpl implements BsnlDao {
	public boolean insertBsnlnetwork(BsnlUser bsnl) {
		boolean flag = false;
		Connection connection=ConnectionClass.getConnection();
		String insertQuery = "insert into bsnl_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
	int operatorId=	bsnlDao.operatorName(bsnl.getOperator().getOperatorname());
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, bsnl.getPlanName());
			preparedStatement.setDouble(2, bsnl.getPrice());
			preparedStatement.setString(3, bsnl.getValidity());
			preparedStatement.setString(4, bsnl.getBenfits());
			preparedStatement.setInt(5,operatorId );
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
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
	
	
	
	
	

	public boolean updateBsnl(String planName, Double price, String validity, String benefits, int bsnlId) {
		Connection connection=ConnectionClass.getConnection();
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String updateQuery = "update bsnl_plans set plan_name=?,price=?,validity=?,benefits=? where bsnlplan_id=?";

		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, planName);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, validity);
			preparedStatement.setString(4, benefits);
			preparedStatement.setInt(5, bsnlId);
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public boolean deleteBsnl(int bsnlId) {
		String query = "select status from bsnl_plans  where bsnlplan_id=?";
		boolean flag = false;
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String deleteQuery = null;
		String status = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bsnlId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				status = resultSet.getString(1);
			}
			if (status != null && status.equalsIgnoreCase("Active")) {
				deleteQuery = "update bsnl_plans set status='inactive' where bsnlplan_id=?";
			} else {
				deleteQuery = "update bsnl_plans set status='Active' where bsnlplan_id=?";
			}
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, bsnlId);
			flag = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public int findbsnlId(String planName, Double price) {
		String query = "select bsnlplan_id from BSNL_plans where plan_name=? and price=?";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int bsnlId = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, planName);
			preparedStatement.setDouble(2, price);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bsnlId = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return bsnlId;

	}

	public List<BsnlUser> showBsnlplan() {
		BsnlUser bsnl = new BsnlUser();
		List<BsnlUser> bsnlList = new ArrayList<>();
		String showQuery = "select bsnlplan_id,plan_name,price,validity,benefits,operator_id,status from BSNL_plans ";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				bsnl = new BsnlUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				bsnl.setBsnlId(resultSet.getInt(1));
				bsnl.setStatus(resultSet.getString("status"));
				bsnlList.add(bsnl);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return bsnlList;
	}

	public List<BsnlUser> showBsnlplan(String search) {
		BsnlUser bsnl = new BsnlUser();
		List<BsnlUser> bsnlList = new ArrayList<>();
		String showQuery = "select bsnlplan_id ,plan_name,price,validity,benefits,operator_id,status from BSNL_plans where status='Active' and plan_name like ? or price like ?";

		Connection connection=ConnectionClass.getConnection();
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
				bsnl = new BsnlUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				bsnlList.add(bsnl);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return bsnlList;
	}

	public BsnlUser findPlan(int id) {
		Connection connection=ConnectionClass.getConnection();
		BsnlDAOImpl bsnlDao = new BsnlDAOImpl();
		int validity = 0;
		// int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
		String query = "select bsnlplan_id,plan_name,price,validity,benefits,operator_id from BSNL_plans where bsnlplan_id=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		BsnlUser plan = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				OperatorDAOImpl operDao = new OperatorDAOImpl();
				Operator operator = operDao.findOperator(resultSet.getInt(6));
				plan = new BsnlUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return plan;

	}

	public int findBsnlvalidity(BsnlUser bsnlUser) {
		Connection connection=ConnectionClass.getConnection();
		BsnlDAOImpl bsnlDAOImpl = new BsnlDAOImpl();
		int validity = 0;
		int bsnlUserId = bsnlDAOImpl.findbsnlId(bsnlUser.getPlanName(), bsnlUser.getPrice());
		String query = "select validity from  BSNL_plans where bsnlplan_id=?" + bsnlUserId;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			preparedStatement.setInt(1, bsnlUserId);
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
	public List<BsnlUser> showuserBsnlplan() {
		BsnlUser bsnl = new BsnlUser();
		List<BsnlUser> bsnlList = new ArrayList<>();
		String showQuery = "select bsnlplan_id,plan_name,price,validity,benefits,operator_id,status from BSNL_plans where status='Active'";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();
			while (resultSet.next()) {
				Operator operator = operatordao.findOperator1(resultSet.getInt(6));
				bsnl = new BsnlUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				bsnl.setBsnlId(resultSet.getInt(1));
				bsnl.setStatus(resultSet.getString("status"));
				bsnlList.add(bsnl);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return bsnlList;
	}


}
