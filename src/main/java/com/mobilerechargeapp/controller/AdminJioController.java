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

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.JioUser;


@WebServlet("/jio")
public class AdminJioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
	    String planName=request.getParameter("planName");
	    Double price=Double.parseDouble(request.getParameter("price"));
		JioDAOImpl jioDao=new JioDAOImpl();
		JioUser jioUser=new JioUser();
		List<JioUser>jioUserList=jioDao.showJioplan();
//		int  findjioId=jioDao.findjioId(planName, price);
	
	   int findjioId=jioDao.findjioId(jioUser.getPlanName(),jioUser.getPrice());
		
//		session.setAttribute("planName",planName );
//		session.setAttribute("price", price);
//		session.setAttribute("findjioId",findjioId);
		session.setAttribute("jiolist",jioUserList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("jio.jsp");
		requestDispatcher.forward(request, response);
		
	}

	
	

}
