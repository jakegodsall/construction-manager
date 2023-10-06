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
@RequestMapping("/api/jobs")
public class JobController {

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs() {
        List<JobDto> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping
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

    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long id) {
        JobDto job = jobService.getJobById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDto> updateJobById(
            @RequestBody JobDto jobDto,
            @PathVariable Long id
    ) {
        JobDto job = jobService.updateJob(jobDto, id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
