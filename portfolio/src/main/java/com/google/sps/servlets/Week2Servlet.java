package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/week-2")
public class Week2Servlet extends HttpServlet {

	List<String> messages = Arrays.asList(
			"Maybe you received this message first",
			"Maybe you received this message second",
			"Maybe you received this message third",
			"Maybe you received this message last",
			"Maybe you received no messages at all"
			);
	
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
