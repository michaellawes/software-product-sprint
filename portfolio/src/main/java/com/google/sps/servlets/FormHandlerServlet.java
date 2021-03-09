package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		
@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {		    
		// Get the value entered in the form.	
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String subject = request.getParameter("subject");
		 String text = request.getParameter("text");

		// Print the value so you can see it in the server logs.
		System.out.println("Recevied " + subject +  " from " + name 
					+ " at " + email + " saying " + text);

		// Write the value to the response so the user can see it.
		response.getWriter().println("You submitted " + subject 
						+ " successfully!");
		response.sendRedirect("https://mlawes-sps-spring21.appspot.com");		
	}
}
