package com.jakegodsall.constructionmanager.service.impl;

import com.jakegodsall.constructionmanager.entity.Address;
import com.jakegodsall.constructionmanager.entity.Job;
import com.jakegodsall.constructionmanager.exception.ResourceNotFoundException;
import com.jakegodsall.constructionmanager.mapper.JobMapper;
import com.jakegodsall.constructionmanager.payload.JobDto;
import com.jakegodsall.constructionmanager.repository.JobRepository;
import com.jakegodsall.constructionmanager.service.JobService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper jobMapper;

    @Override
    public List<JobDto> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(jobMapper::jobToJobDto)
                .toList();
    }

    @Override
    public JobDto getJobById(Long id) {
        // Get the Job entity from the database
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Job", "id", id)
        );
        // Map to DTO and return
        return jobMapper.jobToJobDto(job);
    }

    @Override
    public JobDto createJob(JobDto jobDto) {
        // Map the job DTO to job entity
        Job job = jobMapper.jobDtoToJob(jobDto);
        // Store the job entity in the database
        Job jobFromDb = jobRepository.save(job);
        // Map the job entity from the database to DTO and return
        return jobMapper.jobToJobDto(jobFromDb);
    }

    @Override
    public JobDto updateJob(JobDto jobDto, Long id) {
        // get the job entity with pk = id from the database
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Job", "id", id)
        );
        // update fields of the job entity
        job.getAddress().setStreet(jobDto.getStreet());
        job.getAddress().setCity(jobDto.getCity());
        job.getAddress().setPostcode(jobDto.getPostCode());
        job.setPrice(job.getPrice());
        // save the updated job entity to the database
        Job updatedJob = jobRepository.save(job);
        // map updated job entity to DTO and return
        return jobMapper.jobToJobDto(updatedJob);

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
}
