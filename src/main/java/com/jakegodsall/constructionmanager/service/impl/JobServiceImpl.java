package com.jakegodsall.constructionmanager.service.impl;

import com.jakegodsall.constructionmanager.entity.Address;
import com.jakegodsall.constructionmanager.entity.Job;
import com.jakegodsall.constructionmanager.exception.ResourceNotFoundException;
import com.jakegodsall.constructionmanager.payload.JobDto;
import com.jakegodsall.constructionmanager.repository.JobRepository;
import com.jakegodsall.constructionmanager.service.JobService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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
        // Map the job DTO to job entity
        Job job = mapToEntity(jobDto);
        // Store the job entity in the database
        Job jobFromDb = jobRepository.save(job);
        // Map the job entity from the database to DTO and return
        return mapToDto(jobFromDb);
    }

    @Override
    public JobDto updateJob(JobDto jobDto, Long id) {
        // get the job entity with pk = id from the database
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Job", "id", id)
        );
        // update fields of the job entity
        job.setLastModifiedDate(new Date());
        job.getAddress().setStreet(jobDto.getStreet());
        job.getAddress().setCity(jobDto.getCity());
        job.getAddress().setPostcode(jobDto.getPostCode());
        job.setPrice(job.getPrice());
        // save the updated job entity to the database
        Job updatedJob = jobRepository.save(job);
        // map updated job entity to DTO and return
        return mapToDto(updatedJob);

    }

    @Override
    public void deleteJob(Long id) {
        // get the job entity with pk = id from the database
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Job", "id", id)
        );
        // delete from the database
        jobRepository.delete(job);
    }

    private JobDto mapToDto(Job job) {
        // Map from entity to DTO
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
        // Map from DTO to entity

        // Create an Address class for embedding into job entity
        Address address = new Address();
        address.setStreet(jobDto.getStreet());
        address.setCity(jobDto.getCity());
        address.setPostcode(jobDto.getPostCode());

        Job job = new Job();
        job.setId(jobDto.getId());
        job.setCreatedDate(jobDto.getCreatedDate());
        job.setLastModifiedDate(jobDto.getLastModifiedDate());
        job.setAddress(address);
        job.setPrice(jobDto.getPrice());
        return job;
    }
}
