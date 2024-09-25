package com.skillproof.api.model.request.userRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UpdateUserRequest {

    @NotBlank(message = "City is required.")
    @Size( max = 250, message = "City must be not more  than 250 characters.")
    @Schema(description = "The city of the user", example = "New York", required = true)
    private String city;

    @Size(max = 20, message = "Phone number must be not more than 20 digits.")
    @Schema(description = "The phone of the user should be of 10 digits", example = "1234567890")
    private String phone;

    @Schema(description = "The bio of the user", example = "Happy Coding!!")
    private String bio;
}





