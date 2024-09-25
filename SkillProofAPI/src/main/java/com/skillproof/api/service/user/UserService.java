package com.skillproof.api.service.user;

import com.skillproof.api.model.request.userRequest.CreateUserRequest;
import com.skillproof.api.model.request.userRequest.UpdateUserRequest;
import com.skillproof.api.model.response.userResponse.UserResponse;

import java.util.List;


public interface UserService {
    UserResponse createUser(CreateUserRequest createUserRequest);

    List<UserResponse> getUsers();

    UserResponse getUserById(String id);

    void deleteUserById(String id);

    UserResponse updateUserById(String id, UpdateUserRequest updateUserRequest);
}
