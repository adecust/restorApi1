package org.payartz.restorapi.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MenuRequest {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Long branchId;
}

