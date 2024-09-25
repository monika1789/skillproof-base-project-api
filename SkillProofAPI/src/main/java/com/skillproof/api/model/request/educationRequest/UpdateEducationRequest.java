package com.skillproof.api.model.request.educationRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UpdateEducationRequest {

    @Schema(description = "The start date of the College", example = "YYYY-MM-DD")
    private LocalDate startDate;

    @Schema(description = "The end date of the College", example = "YYYY-MM-DD")
    private LocalDate endDate;

    @Schema(description = "Description about the user education.", example = "Bachelor of Science in abc with a focus on xyz.")
    private String description;

    }

