package com.example.revision_4.Error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor

public class ErrorHandleEx {
private LocalDateTime date;
private HttpStatus status;
private String error;

    public ErrorHandleEx(LocalDateTime date) {
        this.date = LocalDateTime.now();
    }
}
