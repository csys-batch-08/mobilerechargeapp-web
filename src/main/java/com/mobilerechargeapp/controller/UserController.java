package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.exception.ErrorFound;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		long phonenumber=Long.parseLong(request.getParameter("phonenumber"));
		String password=request.getParameter("password");
		String operatorName=request.getParameter("operatorName");

		OperatorDAOImpl operatorDao=new OperatorDAOImpl();
		Operator operator=operatorDao.findOperator(operatorName);
		Connection con=ConnectionClass.getConnection();
		
		PrintWriter pw=response.getWriter();
		pw.write(username);
		pw.write(email);
		User user=new User(username,email,phonenumber,password,operator);
		
    	UserDAOImpl userDao=new UserDAOImpl();
		boolean b = userDao.insertUser(user);
	try {
		if(b) {
			response.sendRedirect("index.jsp");
		}
		else {
			throw new ErrorFound();
			
		}
		}catch(ErrorFound e)
		{
			HttpSession session=request.getSession();
			session.setAttribute("email",e.getMessage2());
			response.sendRedirect("register.jsp");
		}
	
		
	}
		
}


