package command;

import entitiy.Seance;

import javax.servlet.http.HttpServletRequest;

public class EditSeanceCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        GetSeanceCommand gvc = new GetSeanceCommand();
        Seance seance = gvc.getSeance(request.getParameter("id"));
        seance.setHeader(request.getParameter("header"));
        request.setAttribute("seance", seance);
        return "go_to_seance.jsp";
    }
}
