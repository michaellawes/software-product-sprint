package com.google.sps.servlets;

import java.io.IOException;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/week-2")
public class Week2Servlet extends HttpServlet {

	List<String> messages = new ArrayList<>();
	messages.add("Maybe you received this message first");
	messages.add("Maybe you received this message second");
	messages.add("Maybe you received this message third");
	messages.add("Maybe you received this message last");
	messages.add("Maybe you received no messages at all");
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Convert hard-coded messages to JSON
		Gson gson = new Gson();
		String json = gson.toJson(messages);

		// Send the JSON as the response
		response.setContentType("text/html;");
		response.getWriter().println(json);
	}	
}
