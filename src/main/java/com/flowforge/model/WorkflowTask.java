

package com.flowforge.model;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "workflow_tasks")
@Data 
public class WorkflowTask {

    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_version_id", nullable = false)
    private WorkflowVersion workflowVersion;

    @Column(name = "task_key", nullable = false, length = 100)
    private String taskKey;

    @Column(name = "task_type", nullable = false, length = 50)
    private String taskType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "config", nullable = false, columnDefinition = "jsonb")
    private Map<String, Object> config = new HashMap<>();

    @Column(name = "timeout_seconds", nullable = false)
    private Integer timeoutSeconds = 300;

    @Column(name = "max_retries", nullable = false)
    private Integer maxRetries = 3;

    public WorkflowTask() {
    }

    
}