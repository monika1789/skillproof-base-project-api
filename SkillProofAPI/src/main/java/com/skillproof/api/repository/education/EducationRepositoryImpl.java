package com.skillproof.api.repository.education;

import com.skillproof.api.model.entity.Education;
import com.skillproof.api.repository.EducationDao;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class EducationRepositoryImpl implements EducationRepository {
    private final EducationDao educationDao;

    public EducationRepositoryImpl(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Education createEducationDetails(Education education) {
        educationDao.saveAndFlush(education);
        return education;
    }

    @Override
    public Optional<Education> getEducationbyUserId(Long id) {
        return educationDao.findById(id);
    }

    @Override
    public void deleteEducationByUserId(Long id) {
        educationDao.deleteById(id);
    }

    @Override
    public Education updateEducationById(Education education) {
        return educationDao.save(education);
    }

    @Override
    public List<Education> getEducations() {
        return educationDao.findAll();
    }

    public List<Education> findByUserEmailAddress(String emailAddress){
        return educationDao.findByUserEmailAddress(emailAddress);
    }
}
