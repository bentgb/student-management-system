package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public void deleteStudent(Long id) {
        Student deleteThisStudent = entityManager.find(Student.class, id);
        entityManager.remove(deleteThisStudent);
    }

    public List<Student> getByNameNamedParameters(String lastname) {
        String query = "SELECT i FROM Student i WHERE i.lastname = :lastname";
        return entityManager.createQuery(query, Student.class).setParameter("lastname", lastname).getResultList();
    }


    public Student updateStudent2(Student student, Long id) {
        Student updateThisStudent = entityManager.find(Student.class, id);
        updateThisStudent.setFirstName(student.getFirstName());
        // osv

        return student;
    }

    public Set<Student> getAllStudentsBySubject(String subjectName) {

        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT s FROM Subject s INNER JOIN FETCH " +
                        "s.students u WHERE  s.name = :subjectName")
                .setParameter("subjectName", subjectName).getSingleResult();

        return (Set<Student>) subject.getStudents();
    }

}
