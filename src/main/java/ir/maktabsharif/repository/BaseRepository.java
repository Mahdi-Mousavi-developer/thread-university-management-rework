package ir.maktabsharif.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


    public interface BaseRepository<T> {

        void update(T entity) throws SQLException;

        void delete(Long id) throws SQLException;

        void persist(T entity) throws SQLException;

        Optional<T> findById(Long id) throws SQLException;

        List<T> findAll() throws SQLException;


    }
