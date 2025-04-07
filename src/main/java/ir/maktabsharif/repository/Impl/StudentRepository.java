package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.BaseRepository;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//@NamedQuery(name = "Student.findByFirstName", query = "FROM Student WHERE firstName = ?1")

public class StudentRepository implements BaseRepository<Student> {

    private EntityManager entityManager;

/*    public List<Student> findStudentsByFirstName(String firstName) {
        TypedQuery<Student> typedQuery = entityManager.createNamedQuery("Student.findByFirstName" , Student.class);
        typedQuery.setParameter(1, firstName);
        return typedQuery.getResultList();
    }*/


    public Long getStudentsCount() {
        Query query = entityManager.createQuery("SELECT COUNT (s)  FROM Student s");
        return (long) query.getSingleResult();
    }

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void update(Student student) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            Optional<Student> studentOptional = this.findById(student.getId());
            studentOptional.get().setLastName(student.getLastName());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public void delete(Long id) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Student.class, id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void persist(Student student) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();

        }
    }

    @Override
    public Optional<Student> findById(Long id) throws SQLException {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }


    @Override
    public List<Student> findAll()  {
         return entityManager.createQuery("from Student", Student.class).getResultList();

    }
}


