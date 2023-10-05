package com.jakegodsall.constructionmanager.service;

import com.jakegodsall.constructionmanager.payload.JobDto;

import java.util.List;

public interface JobService {
    List<JobDto> getAllJobs();
    JobDto getJobById(Long id);
    JobDto createJob(JobDto jobDto);
    JobDto updateJob(JobDto jobDto, Long id);
    void deleteJob(Long id);
}
