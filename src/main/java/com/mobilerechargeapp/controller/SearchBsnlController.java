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
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.BsnlUser;
import com.mobilerechargeapp.model.JioUser;


@WebServlet("/SearchBsnlController")
public class SearchBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		 * String plan=request.getParameter("bsnlplan"); BsnlDAOImpl bsnlDao=new
		 * BsnlDAOImpl(); List<BsnlUser> ShowPlan=bsnlDao.showBsnlplan(plan); //
		 * List<JioUser> list=new ArrayList<JioUser>(); for(int
		 * i=0;i<ShowPlan.size();i++) { BsnlUser user=ShowPlan.get(i);
		 * if(user.getPlanName().equalsIgnoreCase(plan)) { ShowPlan.add(user); }
		 * 
		 * else if(String.valueOf(user.getPrice()).equalsIgnoreCase(plan)) {
		 * ShowPlan.add(user); }
		 * 
		 * 
		 * 
		 * } HttpSession session=request.getSession(); session.setAttribute("list",
		 * ShowPlan); response.sendRedirect("searchBsnlPlan.jsp");
		 */
		String plan=request.getParameter("bsnlplan");
		BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
		List<BsnlUser> ShowPlan=bsnlDao.showBsnlplan(plan);
		HttpSession session=request.getSession();
		session.setAttribute("bsnlplan",ShowPlan);	
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("searchBsnlPlan.jsp");
		requestDispatcher.forward(request, response);
			
		

	}

}
