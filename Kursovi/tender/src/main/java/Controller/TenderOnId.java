package Controller;

import Entity.Tender;
import Model.TenderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TenderOnId", value = "/TenderOnId")
public class TenderOnId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idCurrentUser = (Integer) request.getSession().getAttribute("idCurrentUser");
        if (idCurrentUser != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            TenderDAO tenderDAO = new TenderDAO();
            Tender tender = tenderDAO.getTenderById(id);
            request.getSession().setAttribute("tender", tender);
            request.getRequestDispatcher("Tender.jsp").forward(request, response);
        } else {
            request.setAttribute("status", "Wrong account");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
