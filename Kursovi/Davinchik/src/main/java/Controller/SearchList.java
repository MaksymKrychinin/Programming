package Controller;

import Entity.ProfileList;
import Model.InviteDAO;
import Model.InviteDAOimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchList", value = "/SearchList")
public class SearchList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("searchName");
        InviteDAO invite = new InviteDAOimpl();
        ProfileList profileList = invite.accountSearchList(search);
        request.getSession().setAttribute("searchList", profileList);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }
}
