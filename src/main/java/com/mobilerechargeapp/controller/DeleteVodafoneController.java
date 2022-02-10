package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.model.VodafoneUser;

@WebServlet("/DeletevodafoneController")
public class DeleteVodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int vodafoneId = Integer.parseInt(request.getParameter("vodfoneId"));
		VodafoneDAOImpl vodafoneDao = new VodafoneDAOImpl();
		boolean b = vodafoneDao.deleteVodafone(vodafoneId);
		if (b) {
			List<VodafoneUser> vodafoneUserList = vodafoneDao.showViplan();
			request.setAttribute("vodafonelist", vodafoneUserList);
			response.sendRedirect("vodafone.jsp");
		}
	}
}
