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

import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.AirtelUser;
import com.mobilerechargeapp.model.JioUser;

@WebServlet("/SearchAirtelPlanController")
public class SearchAirtelPlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String plan = request.getParameter("airtelplan");
		AirtelDAOImpl airtelDao = new AirtelDAOImpl();
		List<AirtelUser> showPlan = airtelDao.showAirtelplan(plan);
		HttpSession session = request.getSession();
		request.setAttribute("airtelplan", showPlan);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchAirtelPlan.jsp");
		requestDispatcher.forward(request, response);
	}
}
