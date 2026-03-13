package com.api.coreapi.common.constant.response.utils;

import lombok.Data;

import java.time.Instant;

@Data
public abstract class BaseEntity {
    private Instant createdAt;

    private Instant updatedAt;

    private String createdBy;

    private String updatedBy;

    private Boolean isDeleted;

}
