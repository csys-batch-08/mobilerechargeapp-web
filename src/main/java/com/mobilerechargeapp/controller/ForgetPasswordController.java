package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.exception.ErrorFound;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

@WebServlet("/ForgetPassword")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		String password1 = request.getParameter("CONFIRM");
		String password2 = request.getParameter("PASSWORD");
		String emailId = null;
		try {
			emailId = request.getParameter("email");
		} catch (NumberFormatException e1) {

			e1.printStackTrace();
		}
		try {
			if (userDAOImpl.emailValid(emailId) != null) {
				try {
					if (password1.equals(password2)) {
						userDAOImpl.forgetPasssword(emailId, password2);
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp?forgotpassword=sucess");
						dispatcher.forward(request, response);
					} else {
						throw new ErrorFound();
					}
				} catch (ErrorFound e) {
					request.setAttribute("PasswordError", e.forgetPassword());
					try {
						RequestDispatcher dispatcher = request.getRequestDispatcher("forgetPassword.jsp");
						dispatcher.forward(request, response);
					} catch (ServletException | IOException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				throw new ErrorFound();
			}
		} catch (ErrorFound e) {
			request.setAttribute("mailError", e.emailValidate());
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("forgetPassword.jsp");
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
