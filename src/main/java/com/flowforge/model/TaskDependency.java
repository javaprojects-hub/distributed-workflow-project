package com.flowforge.model;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "task_dependencies")
@Data 
public class TaskDependency {

    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_version_id", nullable = false)
    private WorkflowVersion workflowVersion;

    @Column(name = "task_key", nullable = false, length = 100)
    private String taskKey;

    @Column(name = "depends_on_task_key", nullable = false, length = 100)
    private String dependsOnTaskKey;

    public TaskDependency() {
    }

    
}
