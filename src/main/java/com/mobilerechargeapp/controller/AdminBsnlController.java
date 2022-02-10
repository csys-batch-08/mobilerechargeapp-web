package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.model.BsnlUser;

@WebServlet("/Bsnl")
public class AdminBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BsnlDAOImpl bsnlDao = new BsnlDAOImpl();
		BsnlUser bsnlUser = new BsnlUser();
		List<BsnlUser> bsnlUserList = bsnlDao.showBsnlplan();
		int findbsnlId = bsnlDao.findbsnlId(bsnlUser.getPlanName(), bsnlUser.getPrice());
		session.setAttribute("findbsnlId", findbsnlId);
		request.setAttribute("bsnllist", bsnlUserList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bsnl.jsp");
		requestDispatcher.forward(request, response);
	}
}
