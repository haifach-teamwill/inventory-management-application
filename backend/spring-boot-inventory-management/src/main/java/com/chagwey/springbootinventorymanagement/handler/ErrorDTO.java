package com.chagwey.springbootinventorymanagement.handler;

import java.util.ArrayList;
import java.util.List;

import com.chagwey.springbootinventorymanagement.exception.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {

    private Integer httpStatusCode; // 200, 201, 400
    private ErrorCode errorCode;
    private String message;
    private List<String> errors = new ArrayList<>();

}
