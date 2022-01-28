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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		String insertQuery = "insert into jio_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, jio.getPlanName());
			preparedStatement.setDouble(2, jio.getPrice());
			preparedStatement.setString(3, jio.getValidity());
			preparedStatement.setString(4, jio.getBenfits());
//			pstmt.setInt(5, jio.getOperator().getOperatorId1());
			String subQuery = "select operator_id,operator_name from operator_details where operator_name=?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(subQuery);
			preparedStatement2.setString(1, jio.getOperator().getOperatorname());
			resultSet = preparedStatement2.executeQuery();
			int opId = 0;
			if (resultSet.next()) {
				opId = resultSet.getInt(1);
			}
			preparedStatement2.setInt(5, opId);
			flag = preparedStatement.executeUpdate() > 0;


		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public boolean updateJio(String planName1, Double price1, String validity1, String benefits1, int jioplanId) {
		String updateQuery = "update jio_plans set plan_name=?,price=?,validity=?,benefits=? where jioplan_id=?";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
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
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public boolean deleteJio(int jioplanId) {

		String deleteQuery = "delete from jio_plans where jioplan_id=?";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement(deleteQuery);

			preparedStatement.setInt(1, jioplanId);
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;
	}

	public List<JioUser> showJioplan() {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<JioUser>();
		String showQuery = "select jioplan_id,plan_name,price,validity,benefits,operator_id from jio_plans";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection =connectionClass.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(showQuery);
			
		    resultSet= preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(6));

//			System.out.println(operator);
				jio = new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), operator);
				jioList.add(jio);
			}
		} catch (SQLException e) {
			System.out.println("invalid");
			e.printStackTrace();
		}
		
		finally {
			ConnectionClass.close(connection, preparedStatement,resultSet );
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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		JioDAOImpl jioDao = new JioDAOImpl();
		int validity = 0;
		int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
//		String Query = "select validity from jio_plans where jioplan_id=" + JioUserId;
		String Query = "select validity from jio_plans where jioplan_id=?"+JioUserId;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement=null;
		try {
            preparedStatement=connection.prepareStatement(Query);
            preparedStatement.setInt(1, JioUserId);
            resultSet=preparedStatement.executeQuery();
//			Statement stmt = con.createStatement();
//			rs = stmt.executeQuery(Query);
			if (resultSet.next()) {
				validity = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement,resultSet );
		}
		return validity;

	}
	
	public List<JioUser> showJioplan1() {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<JioUser>();
		String showQuery = "select jioplan_id,plan_name,price,validity,benefits,operator_id from jio_plans order by price asc ";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(showQuery);
			resultSet=preparedStatement.executeQuery();
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(6));


				jio = new JioUser(resultSet.getString(2),resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), operator);
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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		JioDAOImpl jioDao = new JioDAOImpl();
		int validity=0;
		//int JioUserId = jioDao.findjioId(jioUser.getPlanName(), jioUser.getPrice());
//		String Query = "select jioplan_id,plan_name,price,validity,benefits,operator_id from jio_plans where jioplan_id=" + id;
		String Query = "select jioplan_id,plan_name,price,validity,benefits,operator_id from jio_plans where jioplan_id=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement=null;
		JioUser plan=null;
		try {
             preparedStatement=connection.prepareStatement(Query);
             preparedStatement.setInt(1, id);
             resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				OperatorDAOImpl operDao=new OperatorDAOImpl();
				Operator operator=operDao.findOperator(resultSet.getInt(6));
				plan=new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5),operator );
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement,resultSet );
		}
		return plan;
		
	}
	public List<JioUser> showJioplan(String search) {
		JioUser jio = null;
		List<JioUser> jioList = new ArrayList<JioUser>();
		String showQuery = "select jioplan_id,plan_name,price,validity,benefits,operator_id from jio_plans where plan_name like '"+search+"%' or price like '"+search+"%'";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(showQuery);
			resultSet=preparedStatement.executeQuery();
			OperatorDAOImpl operatordao = new OperatorDAOImpl();

			while (resultSet.next()) {

				Operator operator = operatordao.findOperator1(resultSet.getInt(6));

//			System.out.println(operator);
				jio = new JioUser(resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), operator);
				jioList.add(jio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement,resultSet );
		}
		return jioList;
	}
	
	
	
	

	
	

}
