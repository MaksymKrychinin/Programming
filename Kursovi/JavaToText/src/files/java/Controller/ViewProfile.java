package Controller;

import Entity.Profile;
import Model.UserDAO;
import Model.UserDAOimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewProfile", value = "/ViewProfile")
public class ViewProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO user = new UserDAOimpl();
        Profile profile = user.userById(id);
        Profile currentProfile = (Profile) request.getSession().getAttribute("userData");
        if (profile != null) {
            if (currentProfile != null) {
                if (!user.friends(currentProfile.getId(), profile.getId())) {
                    profile.setPrivateInfo(null);
                }
            } else {
                profile.setPrivateInfo(null);
            }
            request.getSession().setAttribute("profile", profile);
            request.getRequestDispatcher("/profileGeneration.jsp").forward(request, response);
        } else {
            response.sendError(404, "userNotExist");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
