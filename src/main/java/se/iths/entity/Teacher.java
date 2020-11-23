package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@ Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    private String email;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private Set<Subject> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
        subject.setTeacher(null);
    }

    public Teacher(@NotEmpty String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Teacher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

}
