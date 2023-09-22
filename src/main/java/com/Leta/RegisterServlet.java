package com.Leta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao=new DAO();
		String userName=request.getParameter("userName");
		String password=request.getParameter("userPassword");
		User loginInfo= new User(userName,password);
		RequestDispatcher dispatcher = null;
		
		if(!loginInfo.getUserName().equals("")) {
			
			if(dao.addUser(loginInfo)) {
				request.setAttribute("userName", userName);
				dispatcher=request.getRequestDispatcher("registrationWelcomePage.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			dispatcher=request.getRequestDispatcher("index.html");
		}
	
	}

}
