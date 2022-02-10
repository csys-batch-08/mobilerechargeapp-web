package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;
import com.mobilerechargeapp.model.AirtelUser;

@WebServlet("/DeleteairtelController")
public class DeleteAirtelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int airtelId = Integer.parseInt(request.getParameter("airtelId"));
		AirtelDAOImpl airtelDao = new AirtelDAOImpl();
		boolean b = airtelDao.deleteAirtel(airtelId);
		if (b) {
			List<AirtelUser> airtelUserList = airtelDao.showAirtelplan();
			request.setAttribute("airtellist", airtelUserList);
			response.sendRedirect("airtel.jsp");
		}
	}
}