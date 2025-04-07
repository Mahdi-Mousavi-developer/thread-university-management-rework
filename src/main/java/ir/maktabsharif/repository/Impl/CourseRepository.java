package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.BaseRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CourseRepository implements BaseRepository<Course> {

    private EntityManagerProvider entityManagerProvider;

    public CourseRepository(EntityManagerProvider emProvider) {
        this.entityManagerProvider = emProvider;
    }

    @Override
    public void update(Course course) throws SQLException {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        try {
            transaction.begin();
            Optional<Course> examOptional = this.findById(course.getId());
            examOptional.get().setName(course.getName());
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public void delete(Long id) throws SQLException {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        try {
            transaction.begin();
            Course entity = entityManager.find(Course.class, id);
            entityManager.remove(entity);
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void persist(Course entity) throws SQLException {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Course> findById(Long id) throws SQLException {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        Optional<Course> course = null;

        try{
            transaction.begin();
            Course entity = entityManager.find(Course.class, id);
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }
        return course;

    }

    @Override
    public List<Course> findAll() throws SQLException {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
    try {
        transaction.begin();
        List<Course> courses = entityManager.createQuery("from Course").getResultList();
        transaction.commit();
        return courses;
    }
    catch (Exception e) {
        transaction.rollback();
    }
    finally {
        entityManager.close();
    }
    return Collections.emptyList();
    }

}
