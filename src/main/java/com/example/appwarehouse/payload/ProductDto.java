package com.example.appwarehouse.payload;

import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private Integer photoId;
    private Integer categoryId;
    private Integer measurementId;
}
