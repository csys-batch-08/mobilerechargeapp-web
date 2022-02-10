package com.mobilerechargeapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.model.BsnlUser;
import com.mobilerechargeapp.model.Operator;

@WebServlet("/AddbsnlController")
public class AddBsnlController extends HttpServlet {
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
		BsnlUser bsnlUser = new BsnlUser(planname, price, validity, benefits, operator);
		BsnlDAOImpl bsnlDao = new BsnlDAOImpl();
		boolean b = bsnlDao.insertBsnlnetwork(bsnlUser);
		if (b) {
			response.sendRedirect("Bsnl");
		}

	}

}
