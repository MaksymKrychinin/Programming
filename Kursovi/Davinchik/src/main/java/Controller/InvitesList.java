package Controller;

import Entity.Profile;
import Entity.ProfileList;
import Model.InviteDAO;
import Model.InviteDAOimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InvitesList", value = "/InvitesList")
public class InvitesList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Profile profile = (Profile) request.getSession().getAttribute("userData");
        InviteDAO invite = new InviteDAOimpl();
        ProfileList profileList = invite.accountInvitesList(profile.getId());
        request.getSession().setAttribute("invitesList", profileList);
        request.getRequestDispatcher("/invitesList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
