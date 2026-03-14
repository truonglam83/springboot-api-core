package com.api.coreapi.sys.sample;

import com.api.coreapi.common.constant.response.ResponseConstants;
import com.api.coreapi.common.exception.BadRequestException;
import com.api.coreapi.sys.sample.dto.SampleDto;
import com.api.coreapi.sys.sample.dto.SampleRequestDto;
import com.api.coreapi.sys.sample.dto.SampleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SampleService {
    private final SampleMapper sampleMapper;

    public SampleResponseDto getListSample(SampleRequestDto dto) {
        try {

            SampleResponseDto response = new SampleResponseDto();

            int total = sampleMapper.countData(dto);

            List<SampleDto> list = sampleMapper.getData(dto);

            response.setList(list);
            response.setTotal(total);
            response.setPage(dto.getPage());
            response.setSize(dto.getSize());

            response.setMessage(ResponseConstants.SUCCESS_MSG);
            response.setCode(ResponseConstants.SUCCESS_CODE);

            return response;

        } catch (Exception e) {
            throw new BadRequestException();
        }
    }
}
