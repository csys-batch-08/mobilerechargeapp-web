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


/**
 * Servlet implementation class ShowAirtelUser
 */
@WebServlet("/planAirtelUser")
public class ShowAirtelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		AirtelDAOImpl airtelDao=new AirtelDAOImpl();
		List<AirtelUser>airtelUserList=airtelDao.showAirtelplan();
		HttpSession session=request.getSession();
		session.setAttribute("airtellist",airtelUserList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("planAirtelUser.jsp");
		requestDispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
