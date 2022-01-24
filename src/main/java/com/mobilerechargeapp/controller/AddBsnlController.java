package com.mobilerechargeapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.model.BsnlUser;
import com.mobilerechargeapp.model.Operator;

/**
 * Servlet implementation class AddbsnlController
 */
@WebServlet("/AddbsnlController")
public class AddBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBsnlController() {
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
		
		String planname=request.getParameter("planname");
		Double  price=Double.parseDouble(request.getParameter("price"));
		String validity=request.getParameter("validity");
		String benefits=request.getParameter("benefits");
		String operatorName=request.getParameter("operatorName");
		OperatorDAOImpl operatorDao=new OperatorDAOImpl();
		Operator operator=operatorDao.findOperator(operatorName);
		BsnlUser bsnlUser=new BsnlUser(planname,price,validity,benefits,operator);
		BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
		boolean b=bsnlDao.insertBsnlnetwork(bsnlUser);
		if(b==true) {
			response.sendRedirect("bsnl.jsp");
		}
	
	}

}
