package com.example.lab4.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;


import com.example.lab4.config.DataLoader;
import com.example.lab4.model.Market;
import com.example.lab4.view.MarketsView;

@WebServlet(name = "MarketsInfoServlet", value = "/markets")
public class MarketsInfoServlet extends HttpServlet {


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

        MarketsView marketsView = new MarketsView();
        List<Market> markets = new ArrayList<>(dataLoader.getMarkets().getMarkets());
        marketsView.setMarkets(markets);


        session.setAttribute("marketsView", marketsView);
        RequestDispatcher rd = request.getRequestDispatcher("/MarketsInfo.jsp");
        rd.forward(request,response);
    }
}
