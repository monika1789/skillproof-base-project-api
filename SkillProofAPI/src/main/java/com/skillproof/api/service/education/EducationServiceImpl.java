package com.skillproof.api.service.education;

import com.skillproof.api.exception.UserNotFoundException;
import com.skillproof.api.model.entity.Education;
import com.skillproof.api.model.entity.User;
import com.skillproof.api.model.request.educationRequest.CreateEducationRequest;
import com.skillproof.api.model.request.educationRequest.UpdateEducationRequest;
import com.skillproof.api.model.response.educationResponse.EducationResponse;
import com.skillproof.api.repository.education.EducationRepository;
import com.skillproof.api.repository.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {

    private final UserRepository userRepository;
    private final EducationRepository educationRepository;

    public EducationServiceImpl(UserRepository userRepository, EducationRepository educationRepository) {
        this.userRepository = userRepository;
        this.educationRepository = educationRepository;
    }

    private EducationResponse getEducationResponse(Education education){
        ModelMapper modelMapper = new ModelMapper();
        EducationResponse educationResponse = modelMapper.map(education, EducationResponse.class);
        educationResponse.setUserId(education.getUser().getId());
        return educationResponse;
    }

    private Education createEducationEntity(CreateEducationRequest createEducationRequest, User user){
        Education education = new Education();
        education.setUniversity(createEducationRequest.getUniversity());
        education.setCollegeOrSchool(createEducationRequest.getCollegeOrSchool());
        education.setDegree(createEducationRequest.getDegree());
        education.setGrade(createEducationRequest.getGrade());
        education.setDescription(createEducationRequest.getDescription());
        education.setStartDate(createEducationRequest.getStartDate());
        education.setEndDate(createEducationRequest.getEndDate());
        education.setCreatedDate(LocalDateTime.now());
        education.setUpdatedDate(LocalDateTime.now());
        education.setUser(user);

        return education;
    }

    @Override
    public EducationResponse createEducationDetails(CreateEducationRequest createEducationRequest) {
        User user = userRepository.getUserById(createEducationRequest.getUserId()).orElseThrow(() -> new UserNotFoundException("User doesn't exist Id " + createEducationRequest.getUserId()));

        Education education = createEducationEntity(createEducationRequest,user);
        Education savedEducation = educationRepository.createEducationDetails(education);
        return getEducationResponse(savedEducation);
    }

    @Override
    public EducationResponse getEducationByUserId(Long id) {
        Education education = educationRepository.getEducationbyUserId(id).get();
        return getEducationResponse(education);
    }

    @Override
    public void deleteEducationByUserId(Long id) {
        educationRepository.deleteEducationByUserId(id);
    }

    @Override
    public EducationResponse updateEducationById(Long id, UpdateEducationRequest updateEducationRequest) {
        Education education = educationRepository.getEducationbyUserId(id).get();

        education.setStartDate(updateEducationRequest.getStartDate());
        education.setEndDate(updateEducationRequest.getEndDate());
        education.setDescription(updateEducationRequest.getDescription());
        education.setUpdatedDate(LocalDateTime.now());

        Education saveEducation = educationRepository.updateEducationById(education);
        return getEducationResponse(education);
    }

    @Override
    public List<EducationResponse> getEducations() {
        List<Education> educations = educationRepository.getEducations();

        List<EducationResponse> educationResponses = new ArrayList<>();
        for (Education education : educations) {
            EducationResponse educationResponse = getEducationResponse(education);
//            ModelMapper modelMapper = new ModelMapper();
//            EducationResponse educationResponse = modelMapper.map(education, EducationResponse.class);
            educationResponses.add(educationResponse);
        }
        return educationResponses;
    }

    @Override
    public List<EducationResponse> findByUserEmailAddress(String emailAddress) {
        List<Education> educations = educationRepository.findByUserEmailAddress(emailAddress);

        List<EducationResponse> educationResponses = new ArrayList<>();
        for (Education education : educations) {
            EducationResponse educationResponse = getEducationResponse(education);
            educationResponses.add(educationResponse);
        }
        return educationResponses;

    }


}


