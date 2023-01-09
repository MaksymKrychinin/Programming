package Controller;

import Entity.Auction;
import Model.AuctionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchAuction", value = "/SearchAuction")
public class SearchAuction extends HttpServlet {
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
            String auctionName = request.getParameter("auctionName");
            AuctionDao auctionDao = new AuctionDao();
            List<Auction> auctionList = auctionDao.createAuction(auctionName);
            request.getSession().setAttribute("auctionsList", auctionList);
            response.sendRedirect("index.jsp");
        }
    }
}
