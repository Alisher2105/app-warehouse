package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.InputProduct;
import com.example.appwarehouse.payload.InputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.InputProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {

    @Autowired
    InputProductService inputProductService;

    @PostMapping
    public Result addInputProduct(@RequestBody InputProductDto inputProductDto){
        return inputProductService.addInputProduct(inputProductDto);
    }

    @GetMapping
    public List<InputProduct> getInputProduct(){
        return inputProductService.getInputProduct();
    }

    @GetMapping("{id}")
    public InputProduct getInputProductById(@PathVariable Integer id){
        return inputProductService.getInputProductById(id);
    }

    @PutMapping("{id}")
    public Result editInputProductById(@PathVariable Integer id, InputProductDto inputProductDto){
       return inputProductService.editInputProductById(id,inputProductDto);
    }

}
