package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.User;

@WebServlet("/SearchJioPlanController")
public class SearchJioPlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String plan = request.getParameter("jioplan");
		JioDAOImpl jioDao = new JioDAOImpl();
		List<JioUser> showPlan = jioDao.showJioplan(plan);
		HttpSession session = request.getSession();
		request.setAttribute("jioplan", showPlan);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchJioPlan.jsp");
		requestDispatcher.forward(request, response);
	}

}
