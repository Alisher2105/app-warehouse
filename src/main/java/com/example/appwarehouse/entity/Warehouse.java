package com.example.appwarehouse.entity;

import com.example.appwarehouse.entity.template.AbsEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity

public class Warehouse extends AbsEntity {
}
