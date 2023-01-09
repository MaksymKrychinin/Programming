package com.example.backend.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "short_name")
    private String shortName;
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Department> departments;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Faculty faculty = (Faculty) o;

        if (!id.equals(faculty.id)) {
            return false;
        }
        if (!name.equals(faculty.name)) {
            return false;
        }
        return shortName.equals(faculty.shortName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + shortName.hashCode();
        return result;
    }
}
