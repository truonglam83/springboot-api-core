package com.api.coreapi.sys.test;

import com.api.coreapi.common.constant.response.ResponseConstants;
import com.api.coreapi.common.exception.BadRequestException;
import com.api.coreapi.sys.test.dto.TestDbDto;
import com.api.coreapi.sys.test.dto.TestResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private final TestMapper testMapper;

    public TestResponse testJwt() {
        try {
            TestResponse response = new TestResponse();
            response.setCode(ResponseConstants.SUCCESS_CODE);
            response.setMessage(ResponseConstants.SUCCESS_MSG);
            List<TestDbDto> list = testMapper.testDb();
            response.setData(list);
            return response;

        } catch (Exception ex) {
            throw new BadRequestException();
        }

    }
}
