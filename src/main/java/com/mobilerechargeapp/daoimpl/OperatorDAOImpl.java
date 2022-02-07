package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mobilerechargeapp.Dao.OperatorDao;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.util.ConnectionClass;

public class OperatorDAOImpl implements OperatorDao {

	public Operator findOperator(String name) {
		Operator operator = null;
		Connection connection = ConnectionClass.getConnection();
		String query = "select operator_id,operator_name from operator_details where operator_name='" + name + "'";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
//			Statement stmt = connection.createStatement();
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				operator = new Operator(resultSet.getInt(1), resultSet.getString(2));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}
		return operator;

	}

	public int findOperatorId(String name) {
		Connection connection = ConnectionClass.getConnection();
		String query = "select operator_id from operator_details where operator_name='" + name + "'";
		int oId = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				oId = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return oId;

	}

	public Operator findOperator1(int id) {

		Connection connection = ConnectionClass.getConnection();
		String query = "select  operator_id,operator_name from operator_details where operator_id='" + id + "'";

		Operator operator = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				operator = new Operator(resultSet.getInt(1), resultSet.getString(2));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return operator;

	}

	public Operator findOperator(int operatorId) {
		Connection connection = ConnectionClass.getConnection();
		String query = "select * from operator_details where operator_id='" + operatorId + "'";
		Operator operator = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				operator = new Operator(resultSet.getInt(1), resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClass.close(connection, preparedStatement, resultSet);
		}

		return operator;

	}

}