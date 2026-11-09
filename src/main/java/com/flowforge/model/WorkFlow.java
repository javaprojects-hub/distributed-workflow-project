package com.flowforge.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "workflow")
@Data
public class WorkFlow {

    @Id
    @UuidGenerator 
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "workflow_id", nullable = false, length = 11, unique = true)
    private String workflowId;

    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Column(name = "description", length = 250)
    private String description;


    @OneToMany(mappedBy = "workflow")
    private List<WorkflowVersion> versions = new ArrayList<>();

    @CreateTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


}
