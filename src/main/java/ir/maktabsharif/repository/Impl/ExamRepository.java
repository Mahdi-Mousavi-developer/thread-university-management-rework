package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.BaseRepository;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ExamRepository implements BaseRepository<Exam> {

    EntityManager entityManager;

    public ExamRepository(EntityManager entityManger){
        this.entityManager = entityManger;
    }

    @Override
    public void update(Exam exam) throws SQLException {
        try{
            entityManager.getTransaction().begin();
            Optional<Exam> examOptional = this.findById(exam.getId());
            examOptional.get().setTitle(exam.getTitle());
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
            entityManager.remove(entityManager.find(Exam.class, id));
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public void persist(Exam entity) throws SQLException {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public Optional<Exam> findById(Long id) throws SQLException {
        return Optional.ofNullable(entityManager.find(Exam.class, id));
    }

    @Override
    public List<Exam> findAll() throws SQLException {
        return Collections.emptyList();
    }

}
