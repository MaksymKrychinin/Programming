package com.example.autoRent.Controller.FiltersAndListeners;

import com.example.autoRent.Model.Entity.User;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/AddCar", "/AddManager", "/BanUser", "/DeleteCar", "/EditCar", "/GetAllCars", "/GetAllUsers", "/UnbanUser"})
public class AdminFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(AdminFilter.class);
    HttpSession session;
    User user;

    public void init(HttpServletRequest req) {
        session = req.getSession();
        user = (User) session.getAttribute("user");
    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        init(request);
        if (user == null && !user.getRole().equals("admin") && user.getBanStatus()) {
            ((HttpServletResponse) resp).sendRedirect("index.jsp");
            LOG.info("Admin logged in ");
        }
        filterChain.doFilter(req, resp);
    }
}
