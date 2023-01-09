package Controller;

import Entity.Queue;
import Model.QueueDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "actualQueue", value = "/actualQueue")
public class actualQueue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QueueDAO queueDAO = new QueueDAO();
        List<Queue> queueList = queueDAO.actualQueues();
        request.getSession().setAttribute("queuesList", queueList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
