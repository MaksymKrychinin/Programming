package Controller;

import Entity.Profile;
import Model.UserDAO;
import Model.UserDAOimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Edit", value = "/Edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO user = new UserDAOimpl();
        String password = request.getParameter("password");
        String openInfo = request.getParameter("openInfo");
        String privateInfo = request.getParameter("privateInfo");
        Profile profile = (Profile) request.getSession().getAttribute("userData");
        if (password != null) {
            user.changePassword(profile, password);
        }
        if (openInfo != null) {
                user.changeInfoAboutUser(profile, openInfo);
            }
        if (privateInfo != null) {
                    user.changePrivateInfo(profile, privateInfo);
                }
        request.getRequestDispatcher("/edit.jsp").forward(request, response);
    }
}
