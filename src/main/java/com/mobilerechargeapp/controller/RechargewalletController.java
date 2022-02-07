package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

@WebServlet("/RechargewalletController")
public class RechargewalletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Double amount = Double.parseDouble(request.getParameter("amount"));

		UserDAOImpl userDao = new UserDAOImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("CurrentUser");
		user.setWallet(user.getWallet() + amount);
		int i = userDao.updateuserWallet(user);
		if (i != 0) {
			session.setAttribute("amount", user.getWallet());
			session.setAttribute("recharge", i);
			response.sendRedirect("wallet.jsp");

		} else {
			response.sendRedirect("wallet.jsp");
		}

	}

}
