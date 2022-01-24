package com.mobilerechargeapp.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;
import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl;
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.model.HistoryDetails;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		
		HistoryDetails history=(HistoryDetails)session.getAttribute("history");
		
		User user=(User)session.getAttribute("CurrentUser");
		long mobileNumber=Long.parseLong(request.getParameter("mobileNumber"));
		
		 history.setMobileNumber(mobileNumber); 
		
		HistorydetailsDAOImpl hisDao=new HistorydetailsDAOImpl();
		
		
		boolean b=hisDao.insertDetails(history);
		if(b)
		
		{
			PrintWriter out=response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Recharge Successfully');");
			out.println("location='history.jsp';");
			out.println("</script>");
			/* response.sendRedirect("history.jsp"); */
		}
		

		}
		

}
