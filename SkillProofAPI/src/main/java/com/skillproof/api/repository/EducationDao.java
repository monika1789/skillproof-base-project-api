package com.skillproof.api.repository;

import com.skillproof.api.model.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Long> {
   List<Education> findByUserEmailAddress(String emailAddress);
}
