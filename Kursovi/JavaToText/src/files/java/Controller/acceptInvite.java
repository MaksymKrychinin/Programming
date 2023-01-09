package Controller;

import Entity.Profile;
import Model.UserDAO;
import Model.UserDAOimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "acceptInvite", value = "/acceptInvite")
public class acceptInvite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Profile currentProfile = (Profile) request.getSession().getAttribute("userData");
        int id = currentProfile.getId();
        int id1 = Integer.parseInt(request.getParameter("id"));
        UserDAO user = new UserDAOimpl();
        if (user.acceptFriends(id, id1)){
            request.getRequestDispatcher("/profileGeneration.jsp?id="+id1).forward(request, response);
        } else response.sendError(404);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
