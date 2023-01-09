import java.util.*;

public class FirstProblem {
    private Institute institute;
    private List<Student> students;
    private int budgetPlaces;
    private int contractPlaces;

    public FirstProblem(Institute institute, List<Student> students, int budgetPlaces, int contractPlaces) {
        this.institute = institute;
        this.students = students;
        this.budgetPlaces = budgetPlaces;
        this.contractPlaces = contractPlaces;
    }

    public List<Student>getStudentsThatCannotGetToInstitute(){
        List<Student> sortedStudentsThatCannotGetToInstitute = new ArrayList(this.students);
        return sortedStudentsThatCannotGetToInstitute.stream()
                .filter(averageMark -> averageMark.getAverageMark()<60)
                .toList();

    }


    //todo изменить название
    public List<Student> getStudentsThatCannotGetToFaculity(String facultyName){
        List<Student> sortedStudentsByMarks = new ArrayList(this.students);
        Collections.sort(sortedStudentsByMarks,studentMarksComparator);
        sortedStudentsByMarks = sortedStudentsByMarks.subList(0,(this.institute.getFaculity(facultyName).getBudgetPlaces()+
                this.institute.getFaculity(facultyName).getContractPlaces()));
        Collections.sort(sortedStudentsByMarks,studentByAlphabetComparator);
        return sortedStudentsByMarks;

    }


    Comparator<Student> studentByAlphabetComparator = (o1, o2) -> {
        if (Objects.equals(o1.getFirstName(), o2.getFirstName())) return 0;
        return o1.getFirstName().compareTo(o2.getFirstName());
    };
    Comparator<Student> studentMarksComparator = (o1, o2) -> {
        if (o1.getAverageMark() == o2.getAverageMark()) return 0;
        return o1.getRecordBook() > o2.getRecordBook() ? 1 : -1;
    };
    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
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
