package com.flowforge.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowforge.model.WorkflowTask;

public interface WorkflowTaskRepository extends JpaRepository<WorkflowTask, UUID> {

}
