package com.example.appwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String message;
    private boolean success;
    private Objects objects;
    private Integer integer;

    public Result(String message, boolean success,Integer integer) {
        this.message = message;
        this.success = success;
        this.integer = integer;

    }

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
