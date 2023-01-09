package com.example.projectmanagment;

import DAO.TaskDAO;
import Entity.Task;
import Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddTask", value = "/AddTask")
public class AddTask extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("taskName");
        String description = request.getParameter("description");
        int idUser = ((User) request.getSession().getAttribute("user")).getIdUser();
        Task task = new Task(taskName, idUser, description);
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.addTask(task);
        response.sendRedirect("/MyTasks");
    }
}
