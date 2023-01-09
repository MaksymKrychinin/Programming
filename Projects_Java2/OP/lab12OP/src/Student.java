import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private int recordBook;
    private double averageMark;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", recordBook=" + recordBook +
                ", averageMark=" + averageMark +
                '}' +"\n";
    }

    public Student(String firstName, String lastName, int recordBook, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.recordBook = recordBook;
        this.averageMark = averageMark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(int recordBook) {
        this.recordBook = recordBook;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return recordBook == student.recordBook && Double.compare(student.averageMark, averageMark) == 0 && firstName.equals(student.firstName) && lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, recordBook, averageMark);
    }


}
