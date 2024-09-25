package com.skillproof.api.service.user;

import com.skillproof.api.exception.UserNotFoundException;
import com.skillproof.api.model.request.userRequest.CreateUserRequest;
import com.skillproof.api.model.request.userRequest.UpdateUserRequest;
import com.skillproof.api.model.response.userResponse.UserResponse;
import com.skillproof.api.repository.user.UserRepository;
import com.skillproof.api.model.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        String id = RandomStringUtils.randomAlphanumeric(20);
        user.setId(id);
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmailAddress(createUserRequest.getEmailAddress());
        user.setCity(createUserRequest.getCity());
        user.setPassword(createUserRequest.getPassword());
        user.setPhone(createUserRequest.getPhone());
        user.setBio(createUserRequest.getBio());
        String userName = user.getFirstName() + " " + user.getLastName();
        user.setUserName(userName);
        user.setCreatedDate(LocalDateTime.now());
        user.setUpdatedDate(LocalDateTime.now());

        User savedUser = userRepository.createUser(user);
        UserResponse userResponse = new UserResponse();
        ModelMapper modelMapper = new ModelMapper();
        userResponse = modelMapper.map(savedUser, UserResponse.class);
        return userResponse;
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.getUsers();
        if (CollectionUtils.isEmpty(users)) {
            throw new UserNotFoundException("No users found");
        }
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            ModelMapper modelMapper = new ModelMapper();
            UserResponse userResponse = modelMapper.map(user, UserResponse.class);
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    @Override
    public UserResponse getUserById(String id) {
        User user = userRepository.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        ModelMapper modelMapper = new ModelMapper();
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public void deleteUserById(String id) {
        User user = userRepository.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        userRepository.deleteUserById(id);
    }

    @Override
    public UserResponse updateUserById(String id, UpdateUserRequest updateUserRequest) {

        User user = userRepository.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        user.setCity(updateUserRequest.getCity());
        user.setPhone(updateUserRequest.getPhone());
        user.setBio(updateUserRequest.getBio());
        user.setUpdatedDate(LocalDateTime.now());

        User saveUser = userRepository.updateUserById(user);

        ModelMapper modelMapper = new ModelMapper();
        UserResponse userResponse = modelMapper.map(saveUser, UserResponse.class);
        return userResponse;
    }

}
