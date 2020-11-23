package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;


    public Subject(@NotEmpty String name) {
        this.name = name;
    }

       public Subject() {

    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @JsonbTransient
    public Set<Student> getStudents() {
        return students;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
