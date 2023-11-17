package com.jakegodsall.constructionmanager.mapper;

import com.jakegodsall.constructionmanager.entity.Customer;
import com.jakegodsall.constructionmanager.entity.Job;
import com.jakegodsall.constructionmanager.payload.JobDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper {
    Job jobDtoToJob(JobDto jobDto);
    JobDto jobToJobDto(Job job);
}
