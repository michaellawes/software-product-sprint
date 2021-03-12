package com.google.sps.servlets;

import java.io.IOException;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
		
@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {		    
		// Get the value entered in the form.	
		 String name = Jsoup.clean(request.getParameter("name"), Whitelist.none());
		 String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());
		 String subject = Jsoup.clean(request.getParameter("subject"), Whitelist.none());
		 String text = Jsoup.clean(request.getParameter("text"), Whitelist.none());

		 Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
		 KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
		 FullEntity formResponse = 
			 Entity.newBuilder(keyFactory.newKey())
			 	.set("name", name)
				.set("email", email)
				.set("subject", subject)
				.set("text", text)
				.build();
		 datastore.put(formResponse);

		// Write the value to the response so the user can see it.
		response.getWriter().println("You submitted " + subject 
						+ " successfully!");
		response.sendRedirect("https://mlawes-sps-spring21.appspot.com");		
	}
}
