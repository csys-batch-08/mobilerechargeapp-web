package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.model.AirtelUser;
import com.mobilerechargeapp.model.BsnlUser;
import com.mobilerechargeapp.model.HistoryDetails;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.model.VodafoneUser;

@WebServlet("/ShowValidityController")
public class ShowValidityController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("CurrentUser");
		String name = user.getUsername();
		long validity = 0;

		HistorydetailsDAOImpl hisDao = new HistorydetailsDAOImpl();
		List<HistoryDetails> rechargeHistory = hisDao.findUserHistory(user);
		if (rechargeHistory.size() > 0) {
			HistoryDetails history = rechargeHistory.get(0);
			OperatorDAOImpl operDao = new OperatorDAOImpl();
			Operator operator = operDao.findOperator(history.getOperatorId());
			Date sysDate = new Date();
			long timediff = sysDate.getTime() - history.getRechargeDate().getTime();
			long days = timediff / (1000 * 60 * 60 * 24) % 365;
			if (operator != null) {
				JioUser planJio = null;
				AirtelUser planAirtel = null;
				VodafoneUser planVodafone = null;
				BsnlUser planBsnl = null;

				if (operator.getOperatorname().equals("jio")) {

					JioDAOImpl jioDao = new JioDAOImpl();
					planJio = jioDao.findPlan(history.getPlanId());

					validity = Integer.valueOf(planJio.getValidity().split(" ")[0]) - days;

					System.out.println("Days: " + validity);

				} else if (operator.getOperatorname().equals("Airtel")) {
					AirtelDAOImpl airtelDao = new AirtelDAOImpl();
					planAirtel = airtelDao.findPlan(history.getPlanId());

					validity = Integer.valueOf(planAirtel.getValidity().split(" ")[0]) - days;
					System.out.println("Days: " + validity);
				} else if (operator.getOperatorname().equals("Vodafone")) {
					VodafoneDAOImpl vodafoneDao = new VodafoneDAOImpl();
					planVodafone = vodafoneDao.findPlan(history.getPlanId());
					validity = Integer.valueOf(planVodafone.getValidity().split(" ")[0]) - days;
					System.out.println("Days: " + validity);
				} else if (operator.getOperatorname().equals("BSNL")) {
					BsnlDAOImpl bsnlDao = new BsnlDAOImpl();
					planBsnl = bsnlDao.findPlan(history.getPlanId());
					validity = Integer.valueOf(planBsnl.getValidity().split(" ")[0]) - days;
					System.out.println("Days: " + validity);

				}
			}
		}
		session.setAttribute("name", name);
		session.setAttribute("validity", validity);
		response.sendRedirect("operator.jsp");
	}

}
