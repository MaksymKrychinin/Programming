import java.util.List;

public class Institute {
    private String name;
    private List<Faculty> faculties;


    public Institute(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public Faculty getFaculity(String facultyName) {
        return this.faculties.stream().filter(name -> name.getName().equals(facultyName)).findAny().orElseThrow();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
