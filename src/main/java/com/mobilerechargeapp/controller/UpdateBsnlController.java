package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.exception.ErrorFound;
import com.mobilerechargeapp.model.BsnlUser;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class updatebsnlController
 */
@WebServlet("/updatebsnlController")
public class UpdateBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String planname = request.getParameter("planname");
		Double price = Double.parseDouble(request.getParameter("price"));
		String validity = request.getParameter("validity");
		String benefits = request.getParameter("benefits");
		int bsnlId = Integer.parseInt(request.getParameter("bsnlplanid"));
		Connection con = ConnectionClass.getConnection();
		BsnlDAOImpl bsnlDao = new BsnlDAOImpl();
		BsnlUser bsnlUser = new BsnlUser();
		boolean b = bsnlDao.updateBsnl(planname, price, validity, benefits, bsnlId);
		try {
		if (b) {
			response.sendRedirect("Bsnl");
		} else {
			throw new ErrorFound();
		}
	} catch (ErrorFound e) {
		request.setAttribute("bsnlId", e.bsnlId());
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateBsnl.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e1) {
			e1.printStackTrace();
		}
		}

	}

}
