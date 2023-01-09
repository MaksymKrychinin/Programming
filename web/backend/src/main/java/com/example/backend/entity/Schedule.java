package com.example.backend.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @Column(name = "time")
    private String time;
    @Column(name = "classroom")
    private String classroom;
    @ManyToMany
    @JoinTable(
        name = "students_schedules",
        joinColumns = @JoinColumn(name = "schedule_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Schedule schedule = (Schedule) o;

        if (!id.equals(schedule.id)) {
            return false;
        }
        if (!teacher.equals(schedule.teacher)) {
            return false;
        }
        if (!discipline.equals(schedule.discipline)) {
            return false;
        }
        if (!time.equals(schedule.time)) {
            return false;
        }
        return classroom.equals(schedule.classroom);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + teacher.hashCode();
        result = 31 * result + discipline.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + classroom.hashCode();
        return result;
    }
}
