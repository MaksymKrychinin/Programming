package com.example.projectmanagment;

import DAO.TaskDAO;
import Entity.Task;
import Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyTasks", value = "/MyTasks")
public class MyTasks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        TaskDAO taskDAO = new TaskDAO();
        List<Task> taskList = taskDAO.userTasks(user);
        request.setAttribute("myTaskList", taskList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
