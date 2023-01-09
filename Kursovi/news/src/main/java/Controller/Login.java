package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Model.DAO.Login loginDAO = new Model.DAO.Login();
        loginDAO.login(login, password);
        int userId = loginDAO.getUserId();
        if (userId>0) {
            int admin = loginDAO.getAdmin();
            request.getSession().setAttribute("userId", userId);
            request.getSession().setAttribute("admin", admin);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Wrong login or pass");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
