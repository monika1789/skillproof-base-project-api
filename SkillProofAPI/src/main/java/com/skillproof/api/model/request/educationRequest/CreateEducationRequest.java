package com.skillproof.api.model.request.educationRequest;

import com.skillproof.api.model.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CreateEducationRequest {

    @NotBlank(message = "University name is required.")
    @Size(max = 250, message = "University name must be not more than 250 characters.")
    @Schema(description = "The University name of the user", example = "abc University", required = true)
    private String university;

    @NotBlank(message = "College or School name is required.")
    @Size(max = 250, message = "College or School name must be not more than 250 characters.")
    @Schema(description = "The College or School name of the user", example = "abc school", required = true)
    private String collegeOrSchool;

    @NotBlank(message = "Degree name is required.")
    @Size(max = 100, message = " Degree name must be not more than 100 characters.")
    @Schema(description = "The Degree name of the user", example = "Bachelors of abc", required = true)
    private String degree;

    @NotNull(message = "Grade is required.It should be decimal value such as 4.0")
    @Schema(description = "The Grade of the user", example = "4.5", required = true)
    private Float grade;

    @Schema(description = "The start date of the College", example = "YYYY-MM-DD")
    private LocalDate startDate;

    @Schema(description = "The end date of the College", example = "YYYY-MM-DD")
    private LocalDate endDate;

    @Schema(description = "Description about the user education.", example = "Bachelor of Science in abc with a focus on xyz.")
    private String description;

    @Schema(description = "Alphanumeric value of the UserId of the User .", example = "AbCdE!g3")
    private String userId;
}
