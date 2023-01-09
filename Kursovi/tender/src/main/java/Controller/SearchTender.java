package Controller;

import Entity.Tender;
import Model.TenderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchTender", value = "/SearchTender")
public class SearchTender extends HttpServlet {
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
            List<Tender> tenderList = tenderDAO.createTender(tenderName);
            request.getSession().setAttribute("tendersList", tenderList);
            response.sendRedirect("index.jsp");
        }
    }
}
