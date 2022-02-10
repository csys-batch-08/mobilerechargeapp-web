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

@WebServlet("/vodadone")
public class AdminVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		VodafoneDAOImpl vodadoneDao = new VodafoneDAOImpl();
		VodafoneUser vodafoneUser = new VodafoneUser();
		List<VodafoneUser> vodafoneUserList = vodadoneDao.showViplan();
		int findvodafoneId = vodadoneDao.findvodafoneId(vodafoneUser.getPlanName(), vodafoneUser.getPrice());
		session.setAttribute("findvodafoneId", findvodafoneId);
		request.setAttribute("vodafonelist", vodafoneUserList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("vodafone.jsp");
		requestDispatcher.forward(request, response);
	}
}
