package Controller;

import Entity.Queue;
import Model.QueueDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "next", value = "/next")
public class next extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int queueId = ((Queue) request.getSession().getAttribute("queue")).getIdCreator();
        int idCurrentUser = (int) request.getSession().getAttribute("idCurrentUser");
        if (queueId==idCurrentUser){
            QueueDAO queueDAO = new QueueDAO();
            queueDAO.queueNext(queueId);
            response.sendRedirect("/QueueOnId?id="+queueId);
        }else {
            request.setAttribute("status", "Not queue admin");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
