package com.jakegodsall.constructionmanager.repository;

import com.jakegodsall.constructionmanager.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
