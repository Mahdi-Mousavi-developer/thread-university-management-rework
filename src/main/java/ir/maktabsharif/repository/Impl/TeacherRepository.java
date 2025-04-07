package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.BaseRepository;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TeacherRepository implements BaseRepository<Teacher> {

    EntityManager entityManager;

    public TeacherRepository(EntityManager entityManger){
        this.entityManager = entityManger;
    }


    @Override
    public void update(Teacher teacher) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            Optional<Teacher> optionalTeacher = this.findById(teacher.getId());
            optionalTeacher.get().setFirstName(teacher.getFirstName());
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
        }


    }

    @Override
    public void delete(Long id) throws SQLException {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Teacher.class, id));
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public void persist(Teacher teacher) throws SQLException {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(teacher);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public Optional<Teacher> findById(Long id) throws SQLException {
      return Optional.ofNullable(entityManager.find(Teacher.class, id));
    }

    @Override
    public List<Teacher> findAll() throws SQLException {
        try {
            entityManager.getTransaction().begin();
           List<Teacher> teachers = entityManager.createQuery("from Teacher").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return Collections.emptyList();
    }
    }

