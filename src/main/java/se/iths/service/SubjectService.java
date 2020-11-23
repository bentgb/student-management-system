package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {


    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public Subject updateSubject(Subject subject) {
        entityManager.merge(subject);
        return subject;
    }

    public void deleteSubject(Long id) {
        Subject deleteThisSubject = entityManager.find(Subject.class, id);
        entityManager.remove(deleteThisSubject);
    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    // Dynamic
    public List<Subject> getByNameDynamicQuery(String name) {
        String query = "SELECT s FROM Subject s WHERE s.name = '" + name + "'";
        return entityManager.createQuery(query, Subject.class).getResultList();
    }

    // Named Parameters
    public List<Subject> getByNameNamedParameters(String name) {
        String query = "SELECT s FROM Subject s WHERE s.name = :name";
        return entityManager.createQuery(query, Subject.class).setParameter("name", name).getResultList();
    }

    // Positional Parameters
    public List<Subject> getByNamePositionalParameters(String name) {
        String query = "SELECT s FROM Subject s WHERE s.name = ?1";
        return entityManager.createQuery(query, Subject.class).setParameter(1, name).getResultList();
    }

    public List<Subject> getAllSubjectsSortedByName() {
        String query = "SELECT s FROM Subject s ORDER BY s.name";
        return entityManager.createQuery(query, Subject.class).getResultList();
    }
}





