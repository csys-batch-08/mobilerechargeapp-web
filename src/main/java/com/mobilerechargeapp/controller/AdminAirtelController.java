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

import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;

import com.mobilerechargeapp.model.AirtelUser;

@WebServlet("/Airtel")
public class AdminAirtelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		AirtelDAOImpl airtelDao = new AirtelDAOImpl();
		AirtelUser airtelUser = new AirtelUser();
		List<AirtelUser> airtelUserList = airtelDao.showAirtelplan();
		int findairtelId = airtelDao.findairtelId(airtelUser.getPlanName(), airtelUser.getPrice());
		session.setAttribute("findairtelId", findairtelId);
		request.setAttribute("airtellist", airtelUserList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("airtel.jsp");
		requestDispatcher.forward(request, response);
	}

}
