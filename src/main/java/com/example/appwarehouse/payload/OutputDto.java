package com.example.appwarehouse.payload;

import lombok.Data;

import java.util.Date;

@Data
public class OutputDto {
    private Integer warehouseId;
    private Integer currencyId;
    private Integer clientId;
    private Date date;
    private String factureNumber;
    private String code;

}
