package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapp.Dao.OperatorDao;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.util.ConnectionClass;

public class OperatorDAOImpl implements OperatorDao {

	public  Operator findOperator(String name) {
		Operator operator = null;

		Connection con = ConnectionClass.getConnection();
		try {
			Statement stmt = con.createStatement();
			String Query = "select * from operator_details where operator_name='" + name + "'";
			ResultSet rs = stmt.executeQuery(Query);
			if (rs.next()) {
				operator = new Operator(rs.getInt(1), rs.getString(2));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return operator;

	}

	public int findOperatorId(String name) {
		Connection con = ConnectionClass.getConnection();
		String query = "select operator_id from operator_details where operator_name='"+name+"'";
		int oId = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				oId = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return oId;

	}

	public Operator findOperator1(int id) {

		Connection con = ConnectionClass.getConnection();
		String Query = "select * from operator_details where operator_id='" + id + "'";

		Operator operator = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			if (rs.next()) {

				operator = new Operator(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return operator;

	}
	public  Operator findOperator(int operatorId) {
		Connection con = ConnectionClass.getConnection();
		String Query="select * from operator_details where operator_id='" +operatorId+"'";
		Operator operator=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			if(rs.next()) {
				 operator=new Operator(rs.getInt(1),rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return operator;
		
	}

}