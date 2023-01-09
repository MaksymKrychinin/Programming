package Controller;

import Entity.Auction;
import Model.AuctionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuctionOnId", value = "/AuctionOnId")
public class AuctionOnId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idCurrentUser = (Integer) request.getSession().getAttribute("idCurrentUser");
        if (idCurrentUser != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            AuctionDao auctionDao = new AuctionDao();
            Auction auction = auctionDao.getAuctionById(id);
            request.getSession().setAttribute("auction", auction);
            request.getRequestDispatcher("Auction.jsp").forward(request, response);
        } else {
            request.setAttribute("status", "Wrong account");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
