package com.example.projectmanagment;

import DAO.TaskDAO;
import Entity.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditTask", value = "/EditTask")
public class EditTask extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Task task = new Task(id, name, description);
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.editTask(task);
        response.sendRedirect("/MyTasks");
    }
}
