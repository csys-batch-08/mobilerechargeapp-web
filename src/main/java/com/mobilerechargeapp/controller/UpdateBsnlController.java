package com.mobilerechargeapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.model.BsnlUser;

/**
 * Servlet implementation class updatebsnlController
 */
@WebServlet("/updatebsnlController")
public class UpdateBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBsnlController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String planname=request.getParameter("planname");
		Double  price=Double.parseDouble(request.getParameter("price"));
		String validity=request.getParameter("validity");
		String benefits=request.getParameter("benefits");
		int bsnlId =Integer.parseInt(request.getParameter("bsnlplanid"));
		BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
		BsnlUser bsnlUser=new BsnlUser();
		boolean b=bsnlDao.updateBsnl(planname, price, validity, benefits, bsnlId);
		if(b==true) {
			response.sendRedirect("bsnl.jsp");
		}
	

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
}
