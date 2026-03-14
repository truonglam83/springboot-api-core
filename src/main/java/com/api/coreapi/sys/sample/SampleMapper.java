package com.api.coreapi.sys.sample;

import com.api.coreapi.sys.sample.dto.SampleDto;
import com.api.coreapi.sys.sample.dto.SampleRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    int countData(SampleRequestDto dto);

    List<SampleDto> getData(SampleRequestDto dto);
}
