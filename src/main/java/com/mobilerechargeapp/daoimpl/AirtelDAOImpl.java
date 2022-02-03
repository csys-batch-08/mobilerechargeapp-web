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
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		String insertQue = "insert into Airtel_plans (plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		String subQuery = "select operator_id,operator_name from operator_details where operator_name=?";
		PreparedStatement preparedStatement = null;
     	ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(subQuery);
			preparedStatement.setString(1, airtel.getOperator().getOperatorname());
			resultSet=preparedStatement.executeQuery();
			
			int opId = 0;
			if (resultSet.next()) {
				opId = resultSet.getInt(1);
			}
			preparedStatement = connection.prepareStatement(insertQue);
			preparedStatement.setString(1, airtel.getPlanName());
			preparedStatement.setDouble(2, airtel.getPrice());
			preparedStatement.setString(3, airtel.getValidity());
			preparedStatement.setString(4, airtel.getBenfits());
			preparedStatement.setInt(5, opId);
		  	
			
			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement,resultSet );
		}
		return flag;
	}

	
	int airtelplanId = 0;
	public boolean updateAirtel(String planname, Double price, String validity, String benefits, int airtelplanId) {
		
		boolean flag = false;

		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		String updateQuery = "update  Airtel_plans set plan_name=?,price=?,validity=?,benefits=? where airtelplan_id=?";
		PreparedStatement preparedStatement= null;
		ResultSet resultSet=null;
		
		try {
		preparedStatement = connection.prepareStatement(updateQuery);
	
			preparedStatement.setString(1, planname);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, validity);
			preparedStatement.setString(4, benefits);
			preparedStatement.setInt(5, airtelplanId);
			resultSet=preparedStatement.executeQuery();

			flag =preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionClass.close(connection, preparedStatement,resultSet );
		}
		return flag;
	}

	public boolean deleteAirtel(int airtelplanId) {
		boolean flag = false;
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		String deleteQuerey = "delete from Airtel_plans where airtelplan_id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(deleteQuerey);
			preparedStatement.setInt(1, airtelplanId);
//			resultSet = preparedStatement.executeQuery();

			flag = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {

		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return flag;

	}

	public List<AirtelUser> showAirtelplan() {
		AirtelUser airtel = null;
		List<AirtelUser> AirtelList = new ArrayList<AirtelUser>();
		String showQuery = "select airtelplan_id,plan_name,price,validity,benefits,operator_id from Airtel_plans";
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
				airtel = new AirtelUser(resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getString(4), resultSet.getString(5), operator);
		      airtel.setAirtelId(resultSet.getInt(1));
				AirtelList.add(airtel);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return AirtelList;
	}
  
  
	public List<AirtelUser> showAirtelplan(String search) {
		AirtelUser airtel = null;
		List<AirtelUser> AirtelList = new ArrayList<AirtelUser>();
		String showQuery = "select airtelplan_id,plan_name,price,validity,benefits,operator_id from Airtel_plans where plan_name like '"
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
				airtel = new AirtelUser(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getString(4), resultSet.getString(5), operator);
				AirtelList.add(airtel);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return AirtelList;
	}
  
  
  
	public int findairtelId(String planName, Double price) {
		String query = "select airtelplan_id from Airtel_plans where plan_name=? and price=?";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int airtelplanId = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, planName);
			preparedStatement.setDouble(2, price);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				airtelplanId = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return airtelplanId;

	}
  
	public AirtelUser findPlan(int id) {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		AirtelDAOImpl airtelDao = new AirtelDAOImpl();
		int validity = 0;
//		String Query = "select airtelplan_id,plan_name,price,validity,benefits,operator_id from Airtel_plans where airtelplan_id=" + id;
		String Query = "select airtelplan_id,plan_name,price,validity,benefits,operator_id from Airtel_plans where airtelplan_id=?";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		AirtelUser plan = null;
		try {
			preparedStatement = connection.prepareStatement(Query);
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
  
  
  public List<AirtelUser>searchAirtelplan(String plan)
 	{
 		AirtelUser airtel=null;
 		List<AirtelUser> AirtelList=new ArrayList<AirtelUser>();
 		String showQuery="select airtelplan_id,plan_name,price,validity,benefits,operator_id from Airtel_plans where upper (PLAN_NAME)like'" +plan.toUpperCase()+"%'";
 		ConnectionClass conclass=new ConnectionClass();
 		Connection con=conclass.getConnection();
 		try {
 			Statement stmt=con.createStatement();
 			ResultSet rs=stmt.executeQuery(showQuery);
 			OperatorDAOImpl operatordao=new OperatorDAOImpl();
 			while(rs.next()) {
 				Operator operator=operatordao.findOperator1(rs.getInt(6));
 				 airtel=new AirtelUser(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),operator);
 				 AirtelList.add(airtel);
 			}
 		} catch (SQLException e) {
 			
 			e.printStackTrace();
 		}
 		return AirtelList;
 		}
  
  
		public int findAirtelvalidity(AirtelUser airtelUser) {
			ConnectionClass connectionClass = new ConnectionClass();
			Connection connection = connectionClass.getConnection();
			AirtelDAOImpl airtelDAOImpl = new AirtelDAOImpl();
			int validity = 0;
			int AirtelUserId = airtelDAOImpl.findairtelId(airtelUser.getPlanName(), airtelUser.getPrice());
			String Query = "select validity from airtel_plans where airtelplan_id=?" + AirtelUserId;
			ResultSet resultSet = null;
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(Query);
				preparedStatement.setInt(1, AirtelUserId);
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

}
