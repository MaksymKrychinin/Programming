package Controller;

import Entity.Queue;
import Model.QueueDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "joinQueue", value = "/joinQueue")
public class joinQueue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCurrentUser= (int) request.getSession().getAttribute("idCurrentUser");
        if (idCurrentUser == 0) {
            request.setAttribute("status", "Error, wrong login or pass");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            int idQueue = ((Queue)request.getSession().getAttribute("queue")).getIdQueue();
            QueueDAO queueDAO = new QueueDAO();
            queueDAO.joinQueue(idQueue, idCurrentUser);
            response.sendRedirect("/QueueOnId?id="+idQueue);

        }
    }
}
