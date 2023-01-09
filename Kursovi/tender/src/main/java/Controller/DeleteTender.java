package Controller;

import Entity.Tender;
import Model.TenderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTender", value = "/DeleteTender")
public class DeleteTender extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tenderId = ((Tender) request.getSession().getAttribute("tender")).getIdTender();
        int tenderCreatorId = ((Tender) request.getSession().getAttribute("tender")).getIdCreator();
        int idCurrentUser = (int) request.getSession().getAttribute("idCurrentUser");
        if (tenderCreatorId==idCurrentUser){
            TenderDAO tenderDAO = new TenderDAO();
            tenderDAO.deleteTender(tenderId);
            response.sendRedirect("/index.jsp");
        }else {
            request.setAttribute("status", "Not tender admin");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
