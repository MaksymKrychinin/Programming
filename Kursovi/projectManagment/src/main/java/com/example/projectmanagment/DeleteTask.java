package com.example.projectmanagment;

import DAO.TaskDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTask", value = "/DeleteTask")
public class DeleteTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.deleteTask(id);
        response.sendRedirect("/MyTasks");
    }
}
