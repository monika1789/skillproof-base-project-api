package com.skillproof.api.model.response.userResponse;

import com.skillproof.api.model.request.userRequest.CreateUserRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserResponse extends CreateUserRequest {

    @Schema(description = "Automatically generated, Unique ID of the user Containing alphanumeric characters", example = "AbCdEf2gH")
    private String id;

    @Schema(description = "Automatically generated, Local Date and Time when user is created", example = "2023-09-19T02:20:48.701Z")
    private LocalDateTime createdDate;

    @Schema(description = "Automatically generated, Local Date and Time when user is updated", example = "2023-10-19T02:20:48.701Z")
    private LocalDateTime updatedDate;

    @Schema(description = "Automatically generated, Username using Firstname and Lastname", example = "John Doe")
    private String userName;
}
