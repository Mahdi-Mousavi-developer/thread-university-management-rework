package ir.maktabsharif.repository.Impl;

import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.BaseRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository implements BaseRepository<User> {
    @Override
    public void update(User entity) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public void persist(User entity) throws SQLException {

    }

    @Override
    public Optional<User> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() throws SQLException {
        return Collections.emptyList();
    }
}
