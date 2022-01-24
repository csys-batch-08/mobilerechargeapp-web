package com.mobilerechargeapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.model.VodafoneUser;

/**
 * Servlet implementation class UpdatevodafoneController
 */
@WebServlet("/UpdatevodafoneController")
public class UpdateVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVodafoneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String planname=request.getParameter("planname");
		Double  price=Double.parseDouble(request.getParameter("price"));
		String validity=request.getParameter("validity");
		String benefits=request.getParameter("benefits");
		int vodafoneplanid =Integer.parseInt(request.getParameter("ViplanId"));
		VodafoneUser vodafone = new VodafoneUser();
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		boolean b=vodafoneDao.updateVodafone(planname, price, validity, benefits, vodafoneplanid);
		if(b==true) {
			response.sendRedirect("vodafone.jsp");
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
