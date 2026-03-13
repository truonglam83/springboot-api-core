package com.api.coreapi.sys.test.dto;

import com.api.coreapi.common.constant.response.BaseResponseDto;
import lombok.Data;

@Data
public class TestResponse extends BaseResponseDto {
    private String message;
    private String username;
    private String role;
}
