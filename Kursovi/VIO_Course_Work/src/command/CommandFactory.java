package command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static CommandFactory factory = new CommandFactory();

    private final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {

    }

    public static CommandFactory commandFactory() {
        if (factory==null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        commands.put("register", new RegisterCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("main", new MainCommand());
        commands.put("create_seance", new CreateSeanceCommand());
        commands.put("go_to_seance", new GoToSeanceCommand());
        commands.put("edit_seance", new EditSeanceCommand());
        commands.put("delete_seance", new DeleteSeanceCommand());
        commands.put("add_ticket", new AddTicketCommand());
        commands.put("edit_ticket", new EditTicketCommand());
        commands.put("delete_ticket", new DeleteTicketCommand());
        commands.put("buy_ticket", new BuyTicketCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        return commands.get(action);
    }
}
