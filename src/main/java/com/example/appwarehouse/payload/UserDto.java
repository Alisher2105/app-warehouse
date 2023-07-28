package com.example.appwarehouse.payload;

import lombok.Data;

@Data
public class UserDto {
    private Integer warehouseId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String code;
    private String password;
}
