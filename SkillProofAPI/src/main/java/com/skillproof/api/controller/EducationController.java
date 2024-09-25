package com.skillproof.api.controller;

import com.skillproof.api.model.entity.Education;
import com.skillproof.api.model.request.educationRequest.CreateEducationRequest;
import com.skillproof.api.model.request.educationRequest.UpdateEducationRequest;
import com.skillproof.api.model.response.educationResponse.EducationResponse;
import com.skillproof.api.model.response.userResponse.UserResponse;
import com.skillproof.api.service.education.EducationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/educations")
    @Operation(summary = "Create a user education details", description = "Add user education details.")
    public ResponseEntity<EducationResponse> createEducationDetailsByUserId(@Valid @RequestBody CreateEducationRequest createEducationRequest) {
        EducationResponse educationResponse = educationService.createEducationDetails(createEducationRequest);
        return new ResponseEntity<>(educationResponse, HttpStatus.CREATED);
    }

    @GetMapping("/educations")
    @Operation(summary = "Get all the Educations details", description = "Fetch all the education details of the users.")
    public ResponseEntity<List<EducationResponse>> getEducations() {
        List<EducationResponse> educationResponse = educationService.getEducations();
        return new ResponseEntity<>(educationResponse, HttpStatus.OK);
    }

    @GetMapping("/educations/{id}")
    @Operation(summary = "Get education details by id", description = "Fetch a education detail by id.")
    public ResponseEntity<EducationResponse> getEducationByUserId(@PathVariable Long id) {
        EducationResponse educationResponse = educationService.getEducationByUserId(id);
        return new ResponseEntity<>(educationResponse, HttpStatus.OK);
    }

    @DeleteMapping("/educations/{id}")
    @Operation(summary = "Delete education by id", description = "delete the education by id.")
    public ResponseEntity<Void> deleteEducationByUserId(@PathVariable Long id) {
        educationService.deleteEducationByUserId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/educations/{id}")
    @Operation(summary = "Update education detail by id", description = "Update the education detail by id.")
    public ResponseEntity<EducationResponse> updateEducationById(@PathVariable Long id, @Valid @RequestBody UpdateEducationRequest updateEducationRequest) {
        EducationResponse educationResponse = educationService.updateEducationById(id, updateEducationRequest);
        return new ResponseEntity<>(educationResponse, HttpStatus.OK);
    }

    @GetMapping("/educations/by-email")
    @Operation(summary = "Get all the Educations details using User Email Address", description = "Fetch all the education details of the user using email address.")
    public ResponseEntity<List<EducationResponse>> findByUserEmailAddress(@RequestParam String emailAddress) {
        List<EducationResponse> educationResponse = educationService.findByUserEmailAddress(emailAddress);
        return new ResponseEntity<>(educationResponse, HttpStatus.OK);
    }
}
