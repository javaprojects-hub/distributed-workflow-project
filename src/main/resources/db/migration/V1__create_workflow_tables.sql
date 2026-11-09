
CREATE TABLE workflows (
    id UUID PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE workflow_versions (
    id UUID PRIMARY KEY,
    workflow_id UUID NOT NULL REFERENCES workflows(id),
    version_number INTEGER NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    published_at TIMESTAMP,

    CONSTRAINT uk_workflow_version
        UNIQUE (workflow_id, version_number)
);

CREATE TABLE workflow_tasks (
    id UUID PRIMARY KEY,
    workflow_version_id UUID NOT NULL
        REFERENCES workflow_versions(id),
    task_key VARCHAR(100) NOT NULL,
    task_type VARCHAR(50) NOT NULL,
    config JSONB NOT NULL DEFAULT '{}'::jsonb,
    timeout_seconds INTEGER NOT NULL DEFAULT 300,
    max_retries INTEGER NOT NULL DEFAULT 3,

    CONSTRAINT uk_version_task
        UNIQUE (workflow_version_id, task_key)
);

CREATE TABLE task_dependencies (
    id UUID PRIMARY KEY,
    workflow_version_id UUID NOT NULL
        REFERENCES workflow_versions(id),
    task_key VARCHAR(100) NOT NULL,
    depends_on_task_key VARCHAR(100) NOT NULL,

    CONSTRAINT uk_task_dependency
        UNIQUE (
            workflow_version_id,
            task_key,
            depends_on_task_key
        ),

    CONSTRAINT chk_no_self_dependency
        CHECK (task_key <> depends_on_task_key),

    CONSTRAINT fk_dependent_task
        FOREIGN KEY (workflow_version_id, task_key)
        REFERENCES workflow_tasks(workflow_version_id, task_key),

    CONSTRAINT fk_prerequisite_task
        FOREIGN KEY (workflow_version_id, depends_on_task_key)
        REFERENCES workflow_tasks(workflow_version_id, task_key)
);

CREATE INDEX idx_workflow_versions_workflow
    ON workflow_versions(workflow_id);

CREATE INDEX idx_workflow_tasks_version
    ON workflow_tasks(workflow_version_id);
