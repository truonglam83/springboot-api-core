package com.api.coreapi.sys.test;

import com.api.coreapi.sys.test.dto.TestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/jwt")
    public TestResponse testJwt() {
        return testService.testJwt();
    }
}

