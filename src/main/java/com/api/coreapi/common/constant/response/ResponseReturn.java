package com.api.coreapi.common.constant.response;

public final class ResponseReturn {

    private ResponseReturn() {
    }

    public static <T extends BaseResponseDto> T success(T response) {
        response.setCode(ResponseConstants.SUCCESS_CODE);
        response.setMessage(ResponseConstants.SUCCESS_MSG);
        return response;
    }

    public static <T extends BaseResponseDto> T error(
            T response,
            int code,
            String message
    ) {
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
