package com.jakegodsall.constructionmanager.controller;

import com.jakegodsall.constructionmanager.payload.JobDto;
import com.jakegodsall.constructionmanager.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class JobController {

    private static final String API_V1_ENDPOINT = "/api/v1/jobs";
    private static final String API_V1_ENDPOINT_ID = API_V1_ENDPOINT + "/{id}";

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping(API_V1_ENDPOINT)
    public ResponseEntity<List<JobDto>> getAllJobs() {
        List<JobDto> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping(API_V1_ENDPOINT)
    public ResponseEntity<JobDto> postJob(@RequestBody JobDto jobDto) {
        // Create the job entity in the database and store DTO in job
        JobDto job = jobService.createJob(jobDto);
        // Get the URI for location of newly created entity
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(job.getId())
                .toUri();
        // return HTTP response with DTO in body, location and status 302
        return ResponseEntity.created(location).body(job);
    }

    @GetMapping(API_V1_ENDPOINT_ID)
    public ResponseEntity<JobDto> getJobById(@PathVariable Long id) {
        JobDto job = jobService.getJobById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping(API_V1_ENDPOINT_ID)
    public ResponseEntity<JobDto> updateJobById(
            @RequestBody JobDto jobDto,
            @PathVariable Long id
    ) {
        JobDto job = jobService.updateJob(jobDto, id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping(API_V1_ENDPOINT_ID)
    public ResponseEntity<Void> deleteJobById(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
