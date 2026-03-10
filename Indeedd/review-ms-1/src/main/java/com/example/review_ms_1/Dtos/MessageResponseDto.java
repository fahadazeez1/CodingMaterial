package com.example.review_ms_1.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDto {
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private int status;
    private String path;
}
