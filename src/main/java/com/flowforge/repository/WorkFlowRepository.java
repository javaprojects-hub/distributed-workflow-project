package com.flowforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowforge.model.WorkFlow;

@Repository 
public interface WorkFlowRepository extends JpaRepository<WorkFlow, Long> {

}
