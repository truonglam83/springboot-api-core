package com.api.coreapi.common.exception;

import com.api.coreapi.common.exception.dto.ErrorCode;

public class TokenExpiredException extends BaseApiException {
    public TokenExpiredException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
