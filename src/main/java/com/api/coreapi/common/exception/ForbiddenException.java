package com.api.coreapi.common.exception;

import com.api.coreapi.common.exception.dto.ErrorCode;

public class ForbiddenException extends BaseApiException {

    public ForbiddenException() {
        super(ErrorCode.FORBIDDEN);
    }
}