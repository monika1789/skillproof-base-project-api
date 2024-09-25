package com.skillproof.api.model.response.educationResponse;

import com.skillproof.api.model.entity.User;
import com.skillproof.api.model.request.educationRequest.CreateEducationRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class EducationResponse extends CreateEducationRequest {

    private Long id;
    private String userEmail;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String userId;
}


