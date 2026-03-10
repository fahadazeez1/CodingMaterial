package com.example.review_ms_1.Configs;

import com.example.review_ms_1.Dtos.MessageResponseDto;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<MessageResponseDto>
    handleResponseStatusException(ResponseStatusException ex, WebRequest request){
        MessageResponseDto messageResponseDto =MessageResponseDto.builder()
                .message(ex.getReason()!=null ? ex.getReason() : "No Reason Provided")
                .error(ex.getMessage())
                .status(ex.getStatusCode().value())
                .timestamp(LocalDateTime.now())
                .path(request.getDescription(false).replace("uri=",""))
                .build();

        return  new ResponseEntity<>(messageResponseDto,ex.getStatusCode());
    }
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<MessageResponseDto> handleFeignException(FeignException ex, WebRequest request) {
        int statusCode = ex.status() != -1 ? ex.status() : 500;
        HttpStatus httpStatus = HttpStatus.resolve(statusCode);
        if (httpStatus == null) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }MessageResponseDto errorResponse = MessageResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(statusCode)
                .error("Inter-Service Error (" + httpStatus.getReasonPhrase() + ")")
                .message("Validation failed: The requested Company ID does not exist.")
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageResponseDto> handleRuntimeException(RuntimeException ex, WebRequest request) {
        MessageResponseDto errorResponse = MessageResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponseDto>
    handleValidationRelatedError(MethodArgumentNotValidException e , WebRequest request){
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        MessageResponseDto errorResponse = MessageResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(errorMessage)
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);


    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponseDto> handleGlobalException(Exception ex, WebRequest request) {
        MessageResponseDto errorResponse = MessageResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message("An unexpected error occurred: " + ex.getMessage())
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
