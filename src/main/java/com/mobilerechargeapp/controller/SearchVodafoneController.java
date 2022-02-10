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

import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;

import com.mobilerechargeapp.model.VodafoneUser;

@WebServlet("/SearchVodafoneController")
public class SearchVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String plan = request.getParameter("Viplan");
		VodafoneDAOImpl vodafoneDao = new VodafoneDAOImpl();
		List<VodafoneUser> showPlan = vodafoneDao.showViplan(plan);
		HttpSession session = request.getSession();
		request.setAttribute("Viplan", showPlan);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchVodafonePlan.jsp");
		requestDispatcher.forward(request, response);
	}
}
