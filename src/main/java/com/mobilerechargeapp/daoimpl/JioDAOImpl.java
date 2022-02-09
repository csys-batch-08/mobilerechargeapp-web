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
		Connection connection=ConnectionClass.getConnection();
		String insertQuery = "insert into jio_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		JioDAOImpl jioDao=new JioDAOImpl();
	int operatorId=jioDao.operatorName(jio.getOperator().getOperatorname());
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, jio.getPlanName());
			preparedStatement.setDouble(2, jio.getPrice());
			preparedStatement.setString(3, jio.getValidity());
			preparedStatement.setString(4, jio.getBenfits());
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
	
	
	
	
	
	

	public boolean updateJio(String planName1, Double price1, String validity1, String benefits1, int jioplanId) {
		String updateQuery = "update jio_plans set plan_name=?,price=?,validity=?,benefits=? where jioplan_id=?";
		Connection connection=ConnectionClass.getConnection();
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, planName1);
			preparedStatement.setDouble(2, price1);
			preparedStatement.setString(3, validity1);
			preparedStatement.setString(4, benefits1);
			preparedStatement.setInt(5, jioplanId);
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public boolean deleteJio(int jioplanId) {
		
		Connection connection=ConnectionClass.getConnection();
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String deleteQuery = null;
		JioDAOImpl jioDao=new JioDAOImpl();
		String status=jioDao.getStatus(jioplanId);
		try {
            if (status != null && status.equalsIgnoreCase("active")) {
				deleteQuery = "update jio_plans set status='inactive' where jioplan_id=?";
			} else {
				deleteQuery = "update jio_plans set status='Active' where jioplan_id=?";
			}
			preparedStatement = connection.prepareStatement(deleteQuery);
           preparedStatement.setInt(1, jioplanId);
          flag = preparedStatement.executeUpdate()>0;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}
	
	public String getStatus(int jioplanId) {
		String query = "select status from jio_plans  where jioplan_id=?";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String status=null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, jioplanId);
            resultSet = preparedStatement.executeQuery();
        	while (resultSet.next()) {
				status = resultSet.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return status;
	}
	
	
	

	public List<JioUser> showJioplan() {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<>();
		String showQuery = "select jioplan_id,plan_name,price,validity,benefits,operator_id,status from jio_plans";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);

			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(6));

				jio = new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				jio.setJioId(resultSet.getInt(1));
				jio.setStatus(resultSet.getString("status"));
				jioList.add(jio);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return jioList;
	}

	public int findjioId(String planName, Double price) {
		String query = "select jioplan_id from jio_plans where plan_name=? and price=?";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int jioplanId = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, planName);
			preparedStatement.setDouble(2, price);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				jioplanId = resultSet.getInt(1);
				return jioplanId;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return jioplanId;

	}

	public int findJiovalidity(JioUser jioUser) {
		Connection connection=ConnectionClass.getConnection();
		JioDAOImpl jioDao = new JioDAOImpl();
		int validity = 0;
		int jioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
		String query = "select validity from jio_plans where jioplan_id=?" + jioUserId;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, jioUserId);
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

	public List<JioUser> showJioplan1() {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<>();
		String showQuery = "select jioplan_id,plan_name,price,validity,benefits,operator_id from jio_plans order by price asc ";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);
			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(6));

				jio = new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				jioList.add(jio);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		 finally {
				ConnectionClass.close(connection, preparedStatement, resultSet);
			}
		return jioList;
	}

	public JioUser findPlan(int id) {
		Connection connection=ConnectionClass.getConnection();
		JioDAOImpl jioDao = new JioDAOImpl();
		int validity = 0;
		String query = "select jioplan_id,plan_name,price,validity,benefits,operator_id from jio_plans where jioplan_id=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		JioUser plan = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				OperatorDAOImpl operDao = new OperatorDAOImpl();
				Operator operator = operDao.findOperator(resultSet.getInt(6));
				plan = new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return plan;

	}

	public List<JioUser> showJioplan(String search) {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<>();
		String showQuery = "select jioplan_id,plan_name,price,validity,benefits,operator_id,status from jio_plans where status='Active' and plan_name like ? or price like ?";
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
				jio = new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				jio.setJioId(resultSet.getInt(1));
				jio.setStatus(resultSet.getString("status")); 
				jioList.add(jio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return jioList;
	}

	public List<JioUser> showUserJioplan() {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<>();
		String showQuery = "select jioplan_id,plan_name,price,validity,benefits,operator_id,status from jio_plans where status='Active'";
		Connection connection=ConnectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(showQuery);

			resultSet = preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(6));

				jio = new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4),
						resultSet.getString(5), operator);
				jio.setJioId(resultSet.getInt(1));
				jio.setStatus(resultSet.getString("status")); 
				jioList.add(jio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return jioList;
	}


}
