package com.api.coreapi.common.exception;

import com.api.coreapi.common.exception.dto.ErrorCode;

public class NotFoundException extends BaseApiException {
    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}
