package dto;

import java.time.LocalDateTime;


public record WorkflowResponse(String workflowId,
        String name,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {


}
