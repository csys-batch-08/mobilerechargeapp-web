package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.util.ConnectionClass;

@WebServlet("/AddJioController")
public class AddJioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String planname = request.getParameter("planname");
		Double price = Double.parseDouble(request.getParameter("price"));
		String validity = request.getParameter("validity");
		String benefits = request.getParameter("benefits");
		String operatorName = request.getParameter("operatorName");
		OperatorDAOImpl operatorDao = new OperatorDAOImpl();
		Operator operator = operatorDao.findOperator(operatorName);
		Connection con = ConnectionClass.getConnection();
		JioUser jioUser = new JioUser(planname, price, validity, benefits, operator);
		JioDAOImpl jioDao = new JioDAOImpl();
		boolean b = jioDao.insertJionet(jioUser);
		if (b) {
			HttpSession session = request.getSession();
			session.setAttribute("add", b);
			response.sendRedirect("jio");
		}
	}

}
