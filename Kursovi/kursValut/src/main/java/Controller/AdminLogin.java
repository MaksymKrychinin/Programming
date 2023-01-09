package Controller;

import Model.DB.AdminAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AdminLogin", value = "/AdminLogin")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdminAccount account = new AdminAccount();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (account.admin(login, password)) {
            request.getSession().setAttribute("admin", true);
        } else {
            request.getSession().setAttribute("admin", false);
        }
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
