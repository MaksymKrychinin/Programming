import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondProblem {
    private List<Student> students;
    private int budgetPlaces;
    private int contractPlaces;

    public SecondProblem(List<Student> students, int budgetPlaces, int contractPlaces) {
        this.students = students;
        this.budgetPlaces = budgetPlaces;
        this.contractPlaces = contractPlaces;
    }

    public List<Student> getStudents() {
        Collections.sort(students,lastNameComparator.thenComparing(firstNameComparator.thenComparing(recordBookComparator)));
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getBudgetPlaces() {
        return budgetPlaces;
    }

    public void setBudgetPlaces(int budgetPlaces) {
        this.budgetPlaces = budgetPlaces;
    }

    public int getContractPlaces() {
        return contractPlaces;
    }

    public void setContractPlaces(int contractPlaces) {
        this.contractPlaces = contractPlaces;
    }

    Comparator<Student> lastNameComparator = (o1, o2) -> {
        if (o1.getLastName() == o2.getLastName()) return 0;
        return o1.getLastName().compareTo(o2.getLastName());
    };
    Comparator<Student> firstNameComparator = (o1, o2) -> {
        if (o1.getFirstName() == o2.getFirstName()) return 0;
        return o1.getFirstName().compareTo(o2.getFirstName());
    };
    Comparator<Student> recordBookComparator = (o1, o2) -> {
        if (o1.getRecordBook() == o2.getRecordBook()) return 0;
        return o1.getRecordBook()>o2.getRecordBook() ? 1 : -1;
    };
}
