package com.api.coreapi.sys.test;

import com.api.coreapi.common.constant.response.ResponseConstants;
import com.api.coreapi.common.exception.UnauthorizedException;
import com.api.coreapi.security.SessionUser;
import com.api.coreapi.sys.test.dto.TestResponse;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestResponse testJwt() {
        try {
            SessionUser user = SessionUser.getCurrentUser();

            TestResponse response = new TestResponse();
            response.setCode(ResponseConstants.SUCCESS_CODE);
            response.setMessage(ResponseConstants.SUCCESS_MSG);

            if (user != null) {
                response.setUsername(user.getUsername());
                response.setRole(user.getRole());
            }

            return response;
        } catch (Exception ex) {
            throw new UnauthorizedException();
        }

    }
}
