package Controller;

import Entity.Queue;
import Model.QueueDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QueueOnId", value = "/QueueOnId")
public class QueueOnId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idCurrentUser = (Integer) request.getSession().getAttribute("idCurrentUser");
        if (idCurrentUser != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            QueueDAO queueDAO = new QueueDAO();
            Queue queue = queueDAO.getQueueById(id);
            request.getSession().setAttribute("queue", queue);
            request.getRequestDispatcher("Queue.jsp").forward(request, response);
        } else {
            request.setAttribute("status", "Wrong account");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
