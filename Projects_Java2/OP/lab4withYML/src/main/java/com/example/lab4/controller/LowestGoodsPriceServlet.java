package com.example.lab4.controller;

import com.example.lab4.config.DataLoader;
import com.example.lab4.model.Good;
import com.example.lab4.view.GoodView;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LowestGoodsPriceServlet", value = "/price")
public class LowestGoodsPriceServlet extends HttpServlet {

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
        String goodName = request.getParameter("goodLowerPrice");

        GoodView goodView = new GoodView();

        Good good = dataLoader.getGoods().getGoodByName(goodName);
        Map<String, Double> lowestPriceByMarket = dataLoader.getMarkets().findLowestGoodValuePerMarket(goodName);
        goodView.setGood(good);
        goodView.setMarketPrice(lowestPriceByMarket);

        session.setAttribute("goodView", goodView);
        RequestDispatcher rd = request.getRequestDispatcher("/InfoPriceLowest.jsp");
        rd.forward(request,response);
    }
}
