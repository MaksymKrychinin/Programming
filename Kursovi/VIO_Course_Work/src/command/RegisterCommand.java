package command;

import entitiy.Cinema;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class RegisterCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = new User(name, password);

        Cinema cinema = Cinema.getCinema();
        Map<String, User> users = cinema.getUsers();
        boolean add = false;

        if (!users.containsKey(name)) {
            users.put(name, user);
            cinema.setUsers(users);
            add = true;
        }

        if (add) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("system", cinema);
        } else {
            request.setAttribute("notAdd", "Даний користувач вже існує");
        }

        return (add) ? "controller?action=main" : "register.jsp";
    }
}
