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

import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.VodafoneUser;


@WebServlet("/SearchVodafoneController")
public class SearchVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//String plan=request.getParameter("Viplan");
//		
//VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
//List<VodafoneUser>ShowPlan=vodafoneDao.showViplan(plan);
//		
////		List<VodafoneUser> list=new ArrayList<VodafoneUser>();
//		for(int i=0;i<ShowPlan.size();i++)
//		{
//			VodafoneUser user=ShowPlan.get(i);
//		if(user.getPlanName().equalsIgnoreCase(plan))
//		{
//			ShowPlan.add(user);
//		}
//		
//		//Double amount=Double.parseDouble(plan);
//		//String s=String.valueOf(amount);
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
//		response.sendRedirect("searchVodafonePlan.jsp");
//		
		String plan=request.getParameter("Viplan");
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		List<VodafoneUser>ShowPlan=vodafoneDao.showViplan(plan);
		HttpSession session=request.getSession();
		session.setAttribute("Viplan",ShowPlan);	
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("searchVodafonePlan.jsp");
		requestDispatcher.forward(request, response);
			
	}

}
