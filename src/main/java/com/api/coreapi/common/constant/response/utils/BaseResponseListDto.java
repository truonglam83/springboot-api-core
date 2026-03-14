package com.api.coreapi.common.constant.response.utils;

import com.api.coreapi.common.constant.response.BaseResponseDto;
import lombok.Data;

@Data
public class BaseResponseListDto extends BaseResponseDto {
    private int page;
    private int size;
    private long total;
}
