package com.flowforge.service;

import dto.CreateWorkflowRequest;
import dto.WorkflowResponse;

public interface IWorkflowService {

    WorkflowResponse createWorkflow(CreateWorkflowRequest request);
}
