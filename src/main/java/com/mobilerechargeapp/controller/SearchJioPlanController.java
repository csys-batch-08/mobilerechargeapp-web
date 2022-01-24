package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.User;

/**
 * Servlet implementation class SearchJioPlanController
 */
@WebServlet("/SearchJioPlanController")
public class SearchJioPlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchJioPlanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String plan=request.getParameter("jioplan");
		
		JioDAOImpl jioDao=new JioDAOImpl();
		List<JioUser> ShowPlan=jioDao.showJioplan(plan);
//		List<JioUser> list=new ArrayList<JioUser>();
		for(int i=0;i<ShowPlan.size();i++)
		{
			JioUser user=ShowPlan.get(i);
		if(user.getPlanName().equalsIgnoreCase(plan))
		{
			ShowPlan.add(user);
		}
		
		else if(String.valueOf(user.getPrice()).equalsIgnoreCase(plan))
		{
			ShowPlan.add(user);
		}
		
		
		
		}
		HttpSession session=request.getSession();
		session.setAttribute("list", ShowPlan);
		response.sendRedirect("SearchJioPlan.jsp");
		
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
