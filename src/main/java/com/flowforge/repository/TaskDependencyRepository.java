package com.flowforge.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowforge.model.TaskDependency;

@Repository 
public interface TaskDependencyRepository extends JpaRepository<TaskDependency, UUID> {

}
