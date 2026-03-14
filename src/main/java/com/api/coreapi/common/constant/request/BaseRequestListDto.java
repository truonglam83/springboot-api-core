package com.api.coreapi.common.constant.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class BaseRequestListDto {
    @Min(1)
    private int page = 1;

    @Min(1)
    @Max(100)
    private int size = 10;

    @JsonIgnore
    public int getOffset() {
        return (page - 1) * size;
    }
}
