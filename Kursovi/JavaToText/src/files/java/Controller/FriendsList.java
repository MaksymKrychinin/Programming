package Controller;

import Entity.Profile;
import Entity.ProfileList;
import Model.InviteDAO;
import Model.InviteDAOimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FriendsList", value = "/FriendsList")
public class FriendsList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object logged = request.getSession().getAttribute("logged");
        if (logged != null) {
            if ((boolean)logged == true) {
                Profile profile = (Profile) request.getSession().getAttribute("userData");
                InviteDAO invite = new InviteDAOimpl();
                ProfileList profileList = invite.accountFriendsList(profile.getId());
                request.getSession().setAttribute("friendsList", profileList);
                request.getSession().setAttribute("active", 2);
                request.getRequestDispatcher("/friendsList.jsp").forward(request, response);
            } else response.sendError(404, "not logged");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
