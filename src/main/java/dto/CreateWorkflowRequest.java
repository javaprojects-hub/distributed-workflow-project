package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateWorkflowRequest(

        @NotBlank(message = "Workflow name is required")
        @Size(max = 150, message = "Workflow name cannot exceed 150 characters")
        String name,

        @Size(max = 2000, message = "Description cannot exceed 2000 characters")
        String description
) {

}
