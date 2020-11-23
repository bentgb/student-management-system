package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT t from Teacher t", Teacher.class).getResultList();
    }


    public Set<Student> getSpecificStudentsForSubject(String teacherName, String subjectName) {

        // Hämta item med relaterad data
        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT s FROM Subject s INNER JOIN FETCH s.teacher t INNER JOIN FETCH " +
                        "s.students u WHERE t.firstName = :teacherName AND s.name = :subjectName")
                .setParameter("teacherName", teacherName).setParameter("subjectName", subjectName).getSingleResult();

        // Här hämtas Set med USERS från vårat hämtade ITEM
        Set<Student> studentResult = subject.getStudents();

        return studentResult;


    }




}

