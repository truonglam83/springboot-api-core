package com.api.coreapi.sys.sample.dto;

import com.api.coreapi.common.constant.response.utils.BaseResponseListDto;
import lombok.Data;

import java.util.List;

@Data
public class SampleResponseDto extends BaseResponseListDto {
    private List<SampleDto> list;

}
