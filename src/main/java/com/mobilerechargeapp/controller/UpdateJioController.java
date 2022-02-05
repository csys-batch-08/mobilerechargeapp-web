package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class UpdatejioController
 */
@WebServlet("/UpdatejioController")
public class UpdateJioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.getWriter().append("Served at: ").append(request.getContextPath());
		String planname=request.getParameter("planname");
		Double  price=Double.parseDouble(request.getParameter("price"));
		String validity=request.getParameter("validity");
		String benefits=request.getParameter("benefits");
		int jioplanId =Integer.parseInt(request.getParameter("jioplanId"));
		Connection con=ConnectionClass.getConnection();
		JioUser jioUser=new JioUser();
		JioDAOImpl jioDao=new 	JioDAOImpl();
		boolean b=jioDao.updateJio(planname, price, validity, benefits, jioplanId);
		if(b==true) {
			response.sendRedirect("jio");
		}
		
		
		
	}

	

}
