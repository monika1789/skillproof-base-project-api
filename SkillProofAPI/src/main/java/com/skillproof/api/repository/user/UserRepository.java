package com.skillproof.api.repository.user;

import com.skillproof.api.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User createUser(User user);

    List<User> getUsers();

    Optional<User> getUserById(String id);

    void deleteUserById(String id);

    User updateUserById(User user);
}
