package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;


@WebServlet("/ForgetPasswordController")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Connection connection=ConnectionClass.getConnection();
		UserDAOImpl userDao=new UserDAOImpl();
		boolean b=userDao.forgetPasssword(email, password);
		if(b==true) {
			User user = (User) session.getAttribute("CurrentUser");
			response.sendRedirect("index.jsp");
		}
		
	}

	

}
