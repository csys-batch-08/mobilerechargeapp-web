package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.util.ConnectionClass;

@WebServlet("/deleteplan")
public class DeleteJioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int jioId=Integer.parseInt(request.getParameter("jioId"));
		JioDAOImpl jioDao=new JioDAOImpl();
        boolean b=jioDao.deleteJio(jioId);
        if(b) {
        	List<JioUser>jioUserList=jioDao.showJioplan();
        	session.setAttribute("jiolist",jioUserList);
        	response.sendRedirect("jio.jsp");
        	
        }
		
	}


}
