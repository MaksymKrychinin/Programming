package com.example.projectmanagment;

import DAO.TaskDAO;
import Entity.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "AllTask", value = "/AllTask")
public class AllTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDAO taskDAO = new TaskDAO();
        List<Task> taskList = taskDAO.allTask();
        request.setAttribute("taskList", taskList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
