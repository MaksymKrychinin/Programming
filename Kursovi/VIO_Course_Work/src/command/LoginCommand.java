package command;

import entitiy.Cinema;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Cinema cinema = Cinema.getCinema();
        Map<String, User> users = cinema.getUsers();
        User user = users.get(name);
        String resultPage = (user != null && user.getPassword().equals(password)) ? "controller?action=main" : "login.jsp";

        if (user == null) {
            request.setAttribute("notExists", "Такого користувача не існує");
        } else if (user.getPassword().equals(password)){
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("system", cinema);
        } else {
            request.setAttribute("notExists", "Неправильний пароль");
        }

        return resultPage;
    }
}
