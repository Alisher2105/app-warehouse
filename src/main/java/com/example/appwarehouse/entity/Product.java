package com.example.appwarehouse.entity;

import com.example.appwarehouse.entity.template.AbsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {

    @OneToOne
    private Attachment photo;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private Measurement measurement;

    private String code;
}
