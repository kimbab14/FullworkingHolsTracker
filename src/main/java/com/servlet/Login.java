package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.utils.Validate;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	  Validate validate = new Validate();
	  response.setContentType("text/html");
	  String username =  request.getParameter("username");
	  String password = request.getParameter("pass");
	  
	  User user = new User();
	  user.setUsername(username);
	  user.setPassword(password);
	  
	  if (validate.findUser(user) == true ) {
	    //if true then redirect to holiday tracker page
	    RequestDispatcher rs = request.getRequestDispatcher("/Track.jsp");
      rs.forward(request, response);
	    System.out.println("Found");	    
	  } else {
	    //else Register or stay on the same, tell
	    //the user that we can't find the information 
	    //on the database and do register.
	    System.out.println("Not found");
	  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
