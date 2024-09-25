package com.skillproof.api.repository.user;

import com.skillproof.api.model.entity.User;
import com.skillproof.api.repository.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public User updateUserById(User user) {
        return userDao.save(user);
    }


}
