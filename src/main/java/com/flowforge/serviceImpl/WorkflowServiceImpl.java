package com.flowforge.serviceImpl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.flowforge.mappers.WorkFlowmapper;
import com.flowforge.model.WorkFlow;
import com.flowforge.repository.WorkFlowRepository;
import com.flowforge.service.IWorkflowService;
import com.flowforge.utility.WorkFlowIdGeneration;

import dto.CreateWorkflowRequest;
import dto.WorkflowResponse;

@Service 
public class WorkflowServiceImpl implements IWorkflowService {

    private final WorkFlowmapper workFlowmapper;

    private final WorkFlowRepository workFlowRepository;

    private static final Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    public WorkflowServiceImpl(WorkFlowmapper workFlowmapper, WorkFlowRepository workFlowRepository) {

        this.workFlowmapper = workFlowmapper;
        this.workFlowRepository = workFlowRepository;

    }

    @Override
    @Transactional
    public WorkflowResponse createWorkflow(CreateWorkflowRequest request) {

        logger.info("Creating workflow with name: {}", request.name());

        if (request == null) {
            throw new IllegalArgumentException("CreateWorkflowRequest cannot be null");
        }
       
       WorkFlow workflow = new WorkFlow();

       workflow.setWorkflowId(generateWorkflowId());
       workflow.setName(request.name());
       workflow.setDescription(request.description());
       
       
      WorkFlow savedWorkFlow = workFlowRepository.save(workflow);

      logger.info( "Workflow created successfully. Workflow ID: {}",savedWorkFlow.getWorkflowId());

     return workFlowmapper.toWorkflowResponse(savedWorkFlow);
    }


    private String generateWorkflowId() {
        logger.info("Generating unique workflow ID");
        int maxAttempts = 5;

        for (int attempt = 0;  attempt < maxAttempts; attempt++) {

           String workflowId =  WorkFlowIdGeneration.generateWorkflowId();

            if (!workFlowRepository.existsByWorkflowId(workflowId)) {
                return workflowId;
            }

        }

        throw new IllegalStateException("Unable to generate a unique workflow ID");
}
    
}
