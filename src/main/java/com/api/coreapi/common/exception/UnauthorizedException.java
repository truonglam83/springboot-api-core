package com.api.coreapi.common.exception;

import com.api.coreapi.common.exception.dto.ErrorCode;

public class UnauthorizedException extends BaseApiException {

    public UnauthorizedException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
