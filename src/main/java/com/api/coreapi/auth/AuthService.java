package com.api.coreapi.auth;


import com.api.coreapi.auth.dto.LoginRequest;
import com.api.coreapi.auth.dto.LoginResponse;
import com.api.coreapi.auth.util.JwtUtil;
import com.api.coreapi.common.constant.response.ResponseConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();

        if (!"admin".equals(request.getUsername())
                || !"123456".equals(request.getPassword())) {
            response.setCode(ResponseConstants.UNAUTHORIZED_CODE);
            response.setMessage(ResponseConstants.AUTH_FAILED_MSG);
            return response;
        }

        String token = jwtUtil.generateToken(1L, "admin", "ADMIN");

        response.setCode(ResponseConstants.SUCCESS_CODE);
        response.setMessage(ResponseConstants.SUCCESS_MSG);
        response.setToken(token);
        return response;
    }
}
