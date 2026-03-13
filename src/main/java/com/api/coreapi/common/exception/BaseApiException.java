package com.api.coreapi.common.exception;

import com.api.coreapi.common.exception.dto.ErrorCode;
import lombok.Data;

@Data
public class BaseApiException extends RuntimeException {
    private ErrorCode errorCode;

    public BaseApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
