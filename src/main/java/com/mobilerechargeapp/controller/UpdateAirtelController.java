package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.AirtelUser;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class UpdateairtrelController
 */
@WebServlet("/UpdateairtelController")
public class UpdateAirtelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String planname=request.getParameter("planname");
		Double  price=Double.parseDouble(request.getParameter("price"));
		String validity=request.getParameter("validity");
		String benefits=request.getParameter("benefits");
		int airtelplanId =Integer.parseInt(request.getParameter("airtelplanId"));
		
		AirtelUser airtelUser=new 	AirtelUser();
		AirtelDAOImpl airtelDao=new AirtelDAOImpl();
		boolean b=airtelDao.updateAirtel(planname, price, validity, benefits, airtelplanId);
		if(b) {
			response.sendRedirect("Airtel");
		}
    

		
		
	}

}
