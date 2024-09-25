package com.skillproof.api.repository.education;

import com.skillproof.api.model.entity.Education;
import com.skillproof.api.repository.EducationDao;

import java.util.List;
import java.util.Optional;

public interface EducationRepository {
    Education createEducationDetails(Education education);

    Optional<Education> getEducationbyUserId(Long id);

    void deleteEducationByUserId(Long id);

    Education updateEducationById(Education education);

    List<Education> getEducations();

    List<Education> findByUserEmailAddress(String emailAddress);

}
