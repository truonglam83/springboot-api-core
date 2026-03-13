package com.api.coreapi.auth.dto;

import com.api.coreapi.common.constant.response.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse extends BaseResponseDto {
    private String token;
}
