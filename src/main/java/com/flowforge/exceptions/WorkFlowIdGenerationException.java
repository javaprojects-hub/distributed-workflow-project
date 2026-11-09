package com.flowforge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Workflow Id Generation Failed")
public class WorkFlowIdGenerationException extends BusinessException{


    public  WorkFlowIdGenerationException() {

        super(
                "Unable to generate a unique workflow ID",
                "WORKFLOW_ID_GENERATION_FAILED",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}