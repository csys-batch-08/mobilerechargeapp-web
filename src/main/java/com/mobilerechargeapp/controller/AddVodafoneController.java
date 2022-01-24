package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.VodafoneUser;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class AddvodafoneController
 */
@WebServlet("/AddvodafoneController")
public class AddVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVodafoneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
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
		VodafoneUser vodafoneUser=new VodafoneUser(planname,price,validity,benefits,operator);
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		boolean b=vodafoneDao.vodafoneNetwork(vodafoneUser);
		if(b==true) {
			response.sendRedirect("vodafone.jsp");
		}
		else {
			response.sendRedirect("invalid");
		}
		
	}

}
