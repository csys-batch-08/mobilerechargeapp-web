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

import com.mobilerechargeapp.model.BsnlUser;


/**
 * Servlet implementation class ShowBsnlController
 */
@WebServlet("/planBsnlUser")
public class ShowBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBsnlController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
		List<BsnlUser>BsnlUserList=bsnlDao.showBsnlplan();
		HttpSession session=request.getSession();
		session.setAttribute("bsnllist",BsnlUserList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("planBsnlUser.jsp");
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
