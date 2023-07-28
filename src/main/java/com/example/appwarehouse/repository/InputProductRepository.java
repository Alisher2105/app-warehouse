package com.example.appwarehouse.repository;

import com.example.appwarehouse.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {
}
