package Controller;

import Model.QueueDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateQueue", value = "/CreateQueue")
public class CreateQueue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCurrentUser = (int) request.getSession().getAttribute("idCurrentUser");
        if (idCurrentUser == 0) {
            request.setAttribute("status", "Error, wrong login or pass");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            String queueName = request.getParameter("queueName");
            QueueDAO queueDAO = new QueueDAO();
            queueDAO.createQueue(queueName, idCurrentUser);
            response.sendRedirect("index.jsp");
        }
    }
}
