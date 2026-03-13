package com.api.coreapi.common.constant.response;

public final class ResponseConstants {
    private ResponseConstants() {
    }


    // ===== SUCCESS =====
    public static final int SUCCESS_CODE = 2;
    public static final String SUCCESS_MSG = "Success";

    // ===== ERROR =====
    public static final int ERROR_CODE = 1;
    public static final String ERROR_MSG = "Error";

    // ===== AUTH =====
    public static final int AUTH_FAILED_CODE = 101;
    public static final String AUTH_FAILED_MSG = "Invalid credentials";

    public static final int UNAUTHORIZED_CODE = 102;
    public static final String UNAUTHORIZED_MSG = "Unauthorized";
}
