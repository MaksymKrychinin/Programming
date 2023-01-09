package Controller;

import Entity.Queue;
import Model.QueueDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteFromQueueById", value = "/DeleteFromQueueById")
public class DeleteFromQueueById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int queueId = ((Queue) request.getSession().getAttribute("queue")).getIdCreator();
        int idCurrentUser = (int) request.getSession().getAttribute("idCurrentUser");
        if (queueId==idCurrentUser){
            int idUser = Integer.parseInt(request.getParameter("id"));
            QueueDAO queueDAO = new QueueDAO();
            queueDAO.deleteFromQueueById(queueId, idUser);
            response.sendRedirect("/QueueOnId?id="+queueId);
        }else {
            request.setAttribute("status", "Not queue admin");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
