package se.yrgo.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String tuturId;

    private String name;
    private int salary;

    @OneToMany
    private Set<Student> teachingGroup;

    public Tutor() {

    }

    public Tutor(String tutorId, String name, int salary) {
        this.tuturId = tutorId;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new HashSet<Student>();
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public Set<Student> getTeachingGroup() {
        Set<Student> unmodifiable = Collections.unmodifiableSet(this.teachingGroup);
        return unmodifiable;
    }

    public String getTuturId() {
        return tuturId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Tutor [tuturId=" + tuturId + ", name=" + name + ", salary=" + salary + "]";
    }
}
