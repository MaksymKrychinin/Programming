package com.example.lab4.controller;

import com.example.lab4.config.DataLoader;

import com.example.lab4.model.Market;
import com.example.lab4.view.MarketView;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MarketServlet", value = "/market")
public class MarketServlet extends HttpServlet {


    private DataLoader dataLoader;

    @Override
    public void init() throws ServletException {
        try {
            dataLoader = DataLoader.getInstance();
        }catch (IOException ex) {
            throw new ServletException("Problems with markets data");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String marketName = request.getParameter("marketName");

        MarketView marketView = new MarketView();
        Market market = dataLoader.getMarkets().getMarketByName(marketName);
        marketView.setMarket(market);

        session.setAttribute("marketView", marketView);
        RequestDispatcher rd = request.getRequestDispatcher("/MarketPage.jsp");
        rd.forward(request,response);



    }
}
