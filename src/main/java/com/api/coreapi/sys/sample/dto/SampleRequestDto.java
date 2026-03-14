package com.api.coreapi.sys.sample.dto;

import com.api.coreapi.common.constant.request.BaseRequestListDto;
import lombok.Data;

@Data
public class SampleRequestDto extends BaseRequestListDto {
    private String username;
}
