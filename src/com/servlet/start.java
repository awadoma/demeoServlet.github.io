package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Daofactory;
import com.model.daoInterface;
import com.model.login;


@WebServlet("/start")
public class start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     daoInterface daointerface;
 
     public void init() {
    	 Daofactory factory = Daofactory.getinstance();
    	 this.daointerface=factory.initialisDao();
     }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String name = request.getParameter("name");
		//String password = request.getParameter("password");
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login login = new login();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		login.setName(name);
		login.setPassword(password);
		daointerface.save(login);
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("userf", "gooo");
		request.setAttribute("logins", daointerface.getAll() );
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

	}

}
