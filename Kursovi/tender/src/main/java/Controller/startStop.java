package Controller;

import Entity.Tender;
import Model.TenderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "startStop", value = "/startStop")
public class startStop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tenderId = ((Tender) request.getSession().getAttribute("tender")).getIdTender();
        int tenderCreatorId = ((Tender) request.getSession().getAttribute("tender")).getIdCreator();
        int idCurrentUser = (int) request.getSession().getAttribute("idCurrentUser");
        if (tenderCreatorId == idCurrentUser) {
            int status = Integer.parseInt(request.getParameter("startStop"));
            TenderDAO tenderDAO = new TenderDAO();
            tenderDAO.startStop(tenderId, status);
            response.sendRedirect("/TenderOnId?id=" + tenderId);
        } else {
            request.setAttribute("status", "Not tender admin");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
