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

import com.mobilerechargeapp.Dao.UserDao;
import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.model.User;


@WebServlet("/ViewHistoryController")
public class ViewHistoryController extends HttpServlet {


  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session=request.getSession();
	  User user=(User)session.getAttribute("CurrentUser");
	  UserDao userDao=new UserDAOImpl();
      List<Object> list= userDao.history(user.getUserId());
      System.out.println(user.getUserId());
      session.setAttribute("List", list);
	  RequestDispatcher requestDispatcher=request.getRequestDispatcher("history.jsp");
	  requestDispatcher.forward(request, response);
		
	}

}
