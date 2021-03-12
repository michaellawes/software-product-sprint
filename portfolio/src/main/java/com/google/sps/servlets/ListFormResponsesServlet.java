package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.data.Task;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing tasks. */
@WebServlet("/list-responses")
public class ListFormResponsesServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	  throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Task").build();
    QueryResults<Entity> formResults = datastore.run(query);

    List<Task> formResponses = new ArrayList<>();
    while (formResults.hasNext()) {
      Entity entity = formResults.next();
      long id = entity.getKey().getId();
      String name = entity.getString("name");
      String email = entity.getString("email");
      String subject = entity.getString("subject");
      String text = entity.getString("text");
      Task formResponse = new Task(id, name, email, subject, text);
      formResponses.add(formResponse);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(formResponses));
  }
}
