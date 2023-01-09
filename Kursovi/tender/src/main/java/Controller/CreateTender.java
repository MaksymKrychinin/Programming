package Controller;

import Model.TenderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateTender", value = "/CreateTender")
public class CreateTender extends HttpServlet {
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
            String tenderName = request.getParameter("tenderName");
            TenderDAO tenderDAO = new TenderDAO();
            tenderDAO.createTender(tenderName, idCurrentUser);
            response.sendRedirect("index.jsp");
        }
    }
}
