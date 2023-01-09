import java.util.List;

public class Faculty {
    private String name;
    private List<Student> students;
    private int budgetPlaces;
    private int contractPlaces;


    public Faculty(String name, List<Student> students, int budgetPlaces, int contractPlaces) {
        this.name = name;
        this.students = students;
        this.budgetPlaces = budgetPlaces;
        this.contractPlaces = contractPlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
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
}
