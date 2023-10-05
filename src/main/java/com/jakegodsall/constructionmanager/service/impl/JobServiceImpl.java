package com.jakegodsall.constructionmanager.service.impl;

import com.jakegodsall.constructionmanager.entity.Job;
import com.jakegodsall.constructionmanager.exception.ResourceNotFoundException;
import com.jakegodsall.constructionmanager.payload.JobDto;
import com.jakegodsall.constructionmanager.repository.JobRepository;
import com.jakegodsall.constructionmanager.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobDto> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public JobDto getJobById(Long id) {
        // Get the Job entity from the database
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Job", "id", id)
        );
        // Map to DTO and return
        return mapToDto(job);
    }

    @Override
    public JobDto createJob(JobDto jobDto) {
        return null;
    }

    @Override
    public JobDto updateJob(JobDto jobDto, Long id) {
        return null;
    }

    @Override
    public void deleteJob(Long id) {

    }

    private JobDto mapToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setCreatedDate(job.getCreatedDate());
        jobDto.setLastModifiedDate(job.getLastModifiedDate());
        jobDto.setStreet(job.getAddress().getStreet());
        jobDto.setCity(job.getAddress().getCity());
        jobDto.setPostCode(job.getAddress().getPostcode());
        jobDto.setPrice(job.getPrice());
        return jobDto;
    }

    private Job mapToEntity(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setCreatedDate(jobDto.getCreatedDate());
        job.setLastModifiedDate(jobDto.getLastModifiedDate());
        job.getAddress().setStreet(jobDto.getStreet());
        job.getAddress().setCity(jobDto.getCity());
        job.getAddress().setPostcode(jobDto.getPostCode());
        job.setPrice(jobDto.getPrice());
        return job;
    }
}
