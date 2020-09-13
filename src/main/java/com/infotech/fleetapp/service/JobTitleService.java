package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.JobTitle;
import com.infotech.fleetapp.repo.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    private final JobTitleRepository jobTitleRepository;

    @Autowired
    public JobTitleService(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    public List<JobTitle> getAllJobTitles() {
        return jobTitleRepository.findAll();
    }

    public Optional<JobTitle> getJobTitleById(Integer id) {
        return jobTitleRepository.findById(id);
    }

    public void addNewJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public void updateJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public void removeJobTitle(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
