package com.api.coreapi.common.exception;

import com.api.coreapi.common.exception.dto.ErrorCode;

public class BadRequestException extends BaseApiException {
    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST);
    }
}
