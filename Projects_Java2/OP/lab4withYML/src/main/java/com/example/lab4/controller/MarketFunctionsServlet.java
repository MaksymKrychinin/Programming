package com.example.lab4.controller;

import com.example.lab4.config.DataLoader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MarketFunctionsServlet", value = "/MarketFunctionsServlet")
public class MarketFunctionsServlet extends HttpServlet {

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
        String func = request.getParameter("confMarket");
        String marketName = request.getParameter("marketName");

        if(func.equals("DoDiscount")){
            doDicsount(request,marketName);
        }
        if(func.equals("changePrice")){
           changePrice(request,marketName);
        }
        request.setAttribute("marketName",marketName);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/market");
        requestDispatcher.forward(request,response);

    }

    private void doDicsount(HttpServletRequest request,String marketName){
        int percent = Integer.parseInt(request.getParameter("discountPercent"));
        if(percent>100) {
            throw new IllegalArgumentException("Percent must be in range 1%-100%, your percent:" + percent);
        }
        if(percent<1) {
            throw new IllegalArgumentException("Percent must be in range 1%-100%, your percent:" + percent);
        }
        dataLoader.getMarkets().getMarketByName(marketName).doDicsount(percent);

    }
    private void changePrice(HttpServletRequest request,String marketName){
        double price = Double.parseDouble(request.getParameter("newPrice"));
        String goodName =request.getParameter("goodToChangePrice");
        if(price<0) {
            throw new IllegalArgumentException("Price must be zero or higher, Your price: " + price);
        }
        dataLoader.getMarkets().getMarketByName(marketName).setPriceAtGood(price,goodName);
    }
}
