package com.dmantz;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dmantz.dao.LoginDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException{
		String uname= request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		
		
		try {
			LoginDAO dao=new LoginDAO();

			if(dao.check(uname, pass)) {
				
				HttpSession session=request.getSession();
				session.setAttribute("username", uname);

				response.sendRedirect("welcome.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
