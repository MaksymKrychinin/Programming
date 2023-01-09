package Controller;

import Entity.Auction;
import Model.AuctionDao;

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
        int auctionId = ((Auction) request.getSession().getAttribute("auction")).getIdAuction();
        int auctionCreatorId = ((Auction) request.getSession().getAttribute("auction")).getIdCreator();
        int idCurrentUser = (int) request.getSession().getAttribute("idCurrentUser");
        if (auctionCreatorId == idCurrentUser) {
            int status = Integer.parseInt(request.getParameter("startStop"));
            AuctionDao auctionDao = new AuctionDao();
            auctionDao.startStop(auctionId, status);
            response.sendRedirect("/AuctionOnId?id=" + auctionId);
        } else {
            request.setAttribute("status", "Not auction admin");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
