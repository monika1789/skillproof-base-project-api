package com.skillproof.api.controller;

import com.skillproof.api.model.request.userRequest.CreateUserRequest;
import com.skillproof.api.model.request.userRequest.UpdateUserRequest;
import com.skillproof.api.model.response.userResponse.UserResponse;
import com.skillproof.api.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "User Controller", description = "Operations related to users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    @Operation(summary = "Create a new user", description = "Add a new user to the system.")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest){
         UserResponse userResponse = userService.createUser(createUserRequest);
         return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    @Operation(summary = "Get all the Users", description = "Fetch all the users present in the system.")
    public ResponseEntity<List<UserResponse>> getUsers(){
        List<UserResponse> userResponses = userService.getUsers();
            return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "Get a User by ID", description = "Fetch the user by their unique ID")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id){
        UserResponse userResponse = userService.getUserById(id);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PutMapping("users/{id}")
    @Operation(summary = "Update the User by unique ID", description = "Update the user by fetching it through its unique ID.")
    public ResponseEntity<UserResponse> updateUserById(@PathVariable String id, @Valid @RequestBody UpdateUserRequest updateUserRequest){
        UserResponse userResponse = userService.updateUserById( id,updateUserRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping ("/users/{id}")
    @Operation(summary = "Delete the user by Unique ID", description = "Delete the user by fetching it through its unique ID.")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
