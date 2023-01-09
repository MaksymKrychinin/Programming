package Controller;

import Entity.Auction;
import Model.AuctionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAuction", value = "/DeleteAuction")
public class DeleteAuction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int auctionId = ((Auction) request.getSession().getAttribute("auction")).getIdAuction();
        int auctionCreatorId = ((Auction) request.getSession().getAttribute("auction")).getIdCreator();
        int idCurrentUser = (int) request.getSession().getAttribute("idCurrentUser");
        if (auctionCreatorId==idCurrentUser){
            AuctionDao auctionDao = new AuctionDao();
            auctionDao.deleteAuction(auctionId);
            response.sendRedirect("/index.jsp");
        }else {
            request.setAttribute("status", "Not auction admin");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
