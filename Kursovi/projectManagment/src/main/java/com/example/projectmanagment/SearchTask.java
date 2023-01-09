package com.example.projectmanagment;

import DAO.TaskDAO;
import Entity.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchTask", value = "/SearchTask")
public class SearchTask extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("searchText");
        TaskDAO taskDAO = new TaskDAO();
        List<Task> taskList = taskDAO.taskByDescription(searchText);
        request.setAttribute("taskList", taskList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
