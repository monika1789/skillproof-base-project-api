package com.skillproof.api.service.education;

import com.skillproof.api.model.request.educationRequest.CreateEducationRequest;
import com.skillproof.api.model.request.educationRequest.UpdateEducationRequest;
import com.skillproof.api.model.response.educationResponse.EducationResponse;

import java.util.List;

public interface EducationService {

    EducationResponse createEducationDetails( CreateEducationRequest createEducationRequest);

    EducationResponse getEducationByUserId(Long id);

    void deleteEducationByUserId(Long id);

    EducationResponse updateEducationById(Long id, UpdateEducationRequest updateEducationRequest);

    List<EducationResponse> getEducations();

    List<EducationResponse> findByUserEmailAddress(String emailAddress);
}
