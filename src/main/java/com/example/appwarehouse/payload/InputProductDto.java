package com.example.appwarehouse.payload;

import lombok.Data;

import java.util.Date;

@Data
public class InputProductDto {
    private Integer productId;
    private Integer inputId;
    private Double amount;
    private Double price;
    private Date expireDate;
}
