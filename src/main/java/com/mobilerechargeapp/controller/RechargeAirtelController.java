package com.mobilerechargeapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.exception.ErrorFound;

@WebServlet("/RechargeAirtelController")
public class RechargeAirtelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String planName = request.getParameter("planName");
		Double price = Double.parseDouble(request.getParameter("price"));
		String operator = request.getParameter("operator");
		double walletAmt = (Double) session.getAttribute("amount");
		try {
			if (walletAmt > price) {
				session.setAttribute("operator", operator);
				session.setAttribute("planName", planName);
				session.setAttribute("price", price);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("recharge.jsp");
				requestDispatcher.forward(request, response);
			} else {
				throw new ErrorFound();
			}
		} catch (ErrorFound e) {
			session.setAttribute("balanceAirtel", e.getMessage1());
			response.sendRedirect("planAirtelUser");
		}

	}

}
