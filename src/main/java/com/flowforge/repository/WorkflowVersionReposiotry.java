package com.flowforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowforge.model.WorkflowVersion;

@Repository
public interface WorkflowVersionReposiotry extends JpaRepository<WorkflowVersion, Long> {

}
