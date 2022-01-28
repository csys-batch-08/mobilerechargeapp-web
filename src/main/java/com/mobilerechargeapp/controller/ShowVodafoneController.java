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
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;

import com.mobilerechargeapp.model.VodafoneUser;

/**
 * Servlet implementation class ShowVodafoneController
 */
@WebServlet("/planVodafoneUser")
public class ShowVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShowVodafoneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	   VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		List<VodafoneUser>vodafoneUserList=vodafoneDao.showViplan();
		HttpSession session=request.getSession();
		session.setAttribute("Vodafonelist",vodafoneUserList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("planVodafoneUser.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
