package command;

import entitiy.Cinema;
import entitiy.Seance;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetSeanceCommand {

    public Seance getSeance(String id) {
        Seance seance;
        ArrayList<Seance> seances = Cinema.getCinema().getSeances();
        ArrayList<Integer> ids = seances.stream()
                .map(Seance::getId)
                .collect(Collectors.toCollection(ArrayList::new));
        int index = ids.indexOf(Integer.parseInt(id));
        seance = seances.get(index);
        return seance;
    }

}
