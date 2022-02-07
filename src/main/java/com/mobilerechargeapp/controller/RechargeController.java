package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;
import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl;
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.exception.ErrorFound;
import com.mobilerechargeapp.model.HistoryDetails;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;

@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("CurrentUser");
		UserDAOImpl userDao = new UserDAOImpl();
		int userId = userDao.findUserId(user);
		OperatorDAOImpl operDao = new OperatorDAOImpl();
		String operator = (String) session.getAttribute("operator");
		int operatorId = operDao.findOperatorId(operator);
		String planName = (String) session.getAttribute("planName");
		double amount = (double) session.getAttribute("price");
		HistoryDetails history = null;
		int planId;

		if (operator.equals("jio")) {
			JioDAOImpl jioDao = new JioDAOImpl();
			planId = jioDao.findjioId(planName, amount);
		} else if (operator.equals("Airtel")) {
			AirtelDAOImpl airtelDao = new AirtelDAOImpl();
			planId = airtelDao.findairtelId(planName, amount);
		} else if (operator.equals("Vodafone")) {
			VodafoneDAOImpl vodafoneDao = new VodafoneDAOImpl();
			planId = vodafoneDao.findvodafoneId(planName, amount);
		} else {
			BsnlDAOImpl bsnlDao = new BsnlDAOImpl();
			planId = bsnlDao.findbsnlId(planName, amount);
		}
		Date today = new Date();
		history = new HistoryDetails(userId, operatorId, 0, planId, today, amount);
		user.setWallet(user.getWallet() - amount);
		userDao.updateuserWallet(user);
		session.setAttribute("amount", user.getWallet());

		long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));

		history.setMobileNumber(mobileNumber);

		HistorydetailsDAOImpl hisDao = new HistorydetailsDAOImpl();

		boolean b = hisDao.insertDetails(history);
		if (b)

		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Recharge Successfully');");
			out.println("location='ViewHistoryController';");
			out.println("</script>");
		}

	}

}
