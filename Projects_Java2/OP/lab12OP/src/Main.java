import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Rysakov","Bogdan",12,99));
        studentList.add(new Student("Kruchinin","Max",10,15));
        studentList.add(new Student("Kondrasyk","Yaroslav",14,100));
        studentList.add(new Student("Fedchik","Vladislav",1,1));
        studentList.add(new Student("Slusar","Stanislav",1,2));

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(new Faculty("FIST",studentList,2,1));
        facultyList.add(new Faculty("FTI",studentList,1,1));
        Institute institute = new Institute("KPI",facultyList);
        FirstProblem firstProblem = new FirstProblem(institute,studentList,3,2);

        List<Student> problemOneResult = firstProblem.getStudentsThatCannotGetToFaculity("FIST");

        System.out.println(Arrays.toString(problemOneResult.toArray()));
        SecondProblem secondProblem = new SecondProblem(studentList,3,2);
        System.out.println();
        System.out.println(Arrays.toString(secondProblem.getStudents().toArray()));
        System.out.println(Arrays.toString(firstProblem.getStudentsThatCannotGetToInstitute().toArray()));

    }

}
