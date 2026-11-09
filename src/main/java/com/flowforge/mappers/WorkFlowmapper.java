package com.flowforge.mappers;

import org.springframework.stereotype.Component;

import com.flowforge.model.WorkFlow;

import dto.WorkflowResponse;

@Component
public class WorkFlowmapper {

    public static WorkflowResponse toWorkflowResponse(WorkFlow workFlow) {
        return new WorkflowResponse(
                workFlow.getWorkflowId(),
                workFlow.getName(),
                workFlow.getDescription(),
                workFlow.getCreatedAt(),
                workFlow.getUpdatedAt()
        );
    }



    public static WorkFlow toWorkFlow(WorkflowResponse workflowResponse) {
        WorkFlow workFlow = new WorkFlow();
        workFlow.setWorkflowId(workflowResponse.workflowId());
        workFlow.setName(workflowResponse.name());
        workFlow.setDescription(workflowResponse.description());
        return workFlow;
    }


    
}
