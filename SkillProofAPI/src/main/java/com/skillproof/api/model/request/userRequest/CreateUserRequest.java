package com.skillproof.api.model.request.userRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@Schema(description = "Details About Creating the User.")
public class CreateUserRequest {

    @NotBlank(message = "Firstname is required.")
    @Size(max = 100, message = "First name must be not more than 100 characters.")
    @Schema(description = "The First name of the user", example = "John", required = true)
    private String firstName;

    @NotBlank(message = "Lastname is required.")
    @Size(max = 100, message = "Last name must be not more than 100 characters.")
    @Schema(description = "The Last name of the user", example = "Doe", required = true)
    private String lastName;

    @NotBlank(message = "City is required.")
    @Size(max = 250, message = "City must be not more than 250 characters.")
    @Schema(description = "The city of the user", example = "New York", required = true)
    private String city;

    @Size(max = 20, message = "Phone number must be not more than 20 digits.")
    @Schema(description = "The phone of the user should be of 10 digits", example = "1234567890")
    private String phone;

    @NotBlank(message = "Email address is required.")
    @Size(max=100, message = "Email address must not be more than 100 characters.")
    @Email
    @Schema(description = "The email address of the user", example = "johndoe@example.com", required = true)
    private String emailAddress;

    @NotBlank(message = "Password is required.")
    @Schema(description = "The password of the user", example = "Abcd!234", required = true)
    private String password;

    @Schema(description = "The bio of the user", example = "Happy Coding!!")
    private String bio;
}
