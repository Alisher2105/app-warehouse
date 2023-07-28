package com.example.appwarehouse.payload;

import lombok.Data;

@Data
public class OutputProductDto {
    private Integer productId;
    private Integer outputId;
    private Double amount;
    private Double price;
}
