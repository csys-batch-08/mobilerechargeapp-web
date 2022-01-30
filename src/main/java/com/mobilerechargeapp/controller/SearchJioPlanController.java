package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.mobilerechargeapp.model.User;


@WebServlet("/SearchJioPlanController")
public class SearchJioPlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String plan=request.getParameter("jioplan");
//		
//		JioDAOImpl jioDao=new JioDAOImpl();
//		List<JioUser> ShowPlan=jioDao.showJioplan(plan);
////		List<JioUser> list=new ArrayList<JioUser>();
//		for(int i=0;i<ShowPlan.size();i++)
//		{
//			JioUser user=ShowPlan.get(i);
//		if(user.getPlanName().equalsIgnoreCase(plan))
//		{
//			ShowPlan.add(user);
//		}
//		
//		else if(String.valueOf(user.getPrice()).equalsIgnoreCase(plan))
//		{
//			ShowPlan.add(user);
//		}
//		
//		
//		
//		}
//		HttpSession session=request.getSession();
//		session.setAttribute("list", ShowPlan);
//		response.sendRedirect("searchJioPlan.jsp");
		String plan=request.getParameter("jioplan");
		JioDAOImpl jioDao=new JioDAOImpl();
		List<JioUser> ShowPlan=jioDao.showJioplan(plan);
		HttpSession session=request.getSession();
		session.setAttribute("jioplan",ShowPlan);	
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("searchJioPlan.jsp");
		requestDispatcher.forward(request, response);
	}

	

}
