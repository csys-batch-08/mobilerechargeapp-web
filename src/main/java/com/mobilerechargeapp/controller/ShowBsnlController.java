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



@WebServlet("/planBsnlUser")
public class ShowBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
		List<BsnlUser>BsnlUserList=bsnlDao.showBsnlplan();
		HttpSession session=request.getSession();
		session.setAttribute("bsnllist",BsnlUserList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("planBsnlUser.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
