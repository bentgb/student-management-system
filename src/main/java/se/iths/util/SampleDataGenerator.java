package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;


    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Aisha", "Alcebri", "kalle@ankeborg.com", "2423424");
        Student student2 = new Student("Tugba", "Arslan", "kajsa@ankeborg.com", "234134134");
        Student student3 = new Student("Isabella", "Koberg", "isabella@ankeborg.com", "34343434");

        Teacher teacher1 = new Teacher("Martin", "Bloomberg", "goofy@ankeborg.com");
        Teacher teacher2 = new Teacher("Alexander", "Lukas", "alex@ankeborg.com");

        Subject subject1 = new Subject("Matte");
        Subject subject2 = new Subject("Engelska");
        Subject subject3 = new Subject("Java");
        Subject subject4 = new Subject("Svenska");
        Subject subject5 = new Subject("C#");


        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student2.addSubject(subject4);
        student2.addSubject(subject5);
        student2.addSubject(subject1);
        student3.addSubject(subject3);
        student3.addSubject(subject5);


        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject4);
        teacher2.addSubject(subject5);


        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(teacher1);
        entityManager.persist(teacher2);

    }












}


