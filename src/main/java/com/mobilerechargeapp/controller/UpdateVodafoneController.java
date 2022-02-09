package com.mobilerechargeapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.exception.ErrorFound;
import com.mobilerechargeapp.model.VodafoneUser;


@WebServlet("/UpdatevodafoneController")
public class UpdateVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String planname = request.getParameter("planname");
		Double price = Double.parseDouble(request.getParameter("price"));
		String validity = request.getParameter("validity");
		String benefits = request.getParameter("benefits");
		int vodafoneplanid = Integer.parseInt(request.getParameter("ViplanId"));
		VodafoneUser vodafone = new VodafoneUser();
		VodafoneDAOImpl vodafoneDao = new VodafoneDAOImpl();
		boolean b = vodafoneDao.updateVodafone(planname, price, validity, benefits, vodafoneplanid);
		try {
		if (b) {
			response.sendRedirect("vodadone");
		} else {
			throw new ErrorFound();
		}
	} catch (ErrorFound e) {
		request.setAttribute("vodafoneplanid", e.vodafoneId());
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateVodafone.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e1) {
			e1.printStackTrace();
		}
		}
	}

}
