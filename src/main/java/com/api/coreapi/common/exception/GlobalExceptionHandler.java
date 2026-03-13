package com.api.coreapi.common.exception;

import com.api.coreapi.common.constant.response.BaseResponseDto;
import com.api.coreapi.common.exception.dto.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseApiException.class)
    public ResponseEntity<BaseResponseDto<?>> handleBaseApiException(BaseApiException ex) {

        ErrorCode error = ex.getErrorCode();

        BaseResponseDto<?> response = BaseResponseDto.builder()
                .code(error.getCode())
                .message(error.getMessage())
                .build();

        return ResponseEntity
                .status(error.getStatus())
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponseDto<?>> handleUnknownException(Exception ex) {
        BaseResponseDto<?> response = BaseResponseDto.builder()
                .code(ErrorCode.INTERNAL_ERROR.getCode())
                .message(ErrorCode.INTERNAL_ERROR.getMessage())
                .build();

        return ResponseEntity
                .status(ErrorCode.INTERNAL_ERROR.getStatus())
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDto<?>> handleValidationException(
            MethodArgumentNotValidException ex
    ) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        BaseResponseDto<Map<String, String>> response =
                BaseResponseDto.<Map<String, String>>builder()
                        .code(99)
                        .message("Validation failed")
                        .data(errors)
                        .build();

        return ResponseEntity.badRequest().body(response);
    }
}
