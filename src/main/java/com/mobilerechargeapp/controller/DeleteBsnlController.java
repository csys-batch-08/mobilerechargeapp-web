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

import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.BsnlUser;
import com.mobilerechargeapp.util.ConnectionClass;

@WebServlet("/DeletebsnlController")
public class DeleteBsnlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int bsnlId = Integer.parseInt(request.getParameter("bsnlId"));
		BsnlDAOImpl bsnlDao = new BsnlDAOImpl();
		boolean b = bsnlDao.deleteBsnl(bsnlId);
		if (b) {
			List<BsnlUser> bsnlUserList = bsnlDao.showBsnlplan();
			request.setAttribute("bsnllist", bsnlUserList);
			response.sendRedirect("Bsnl");

		}
	}

}
