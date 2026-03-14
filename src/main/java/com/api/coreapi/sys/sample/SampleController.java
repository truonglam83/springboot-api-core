package com.api.coreapi.sys.sample;

import com.api.coreapi.sys.sample.dto.SampleRequestDto;
import com.api.coreapi.sys.sample.dto.SampleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/sample")
public class SampleController {
    private final SampleService sampleService;

    @PostMapping("/getListSample")
    public SampleResponseDto getListSample(SampleRequestDto request) {
        return sampleService.getListSample(request);
    }
}
