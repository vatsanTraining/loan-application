package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String errorCode;
    private String description;
    private LocalDateTime dateTime;
    private String url;

}
