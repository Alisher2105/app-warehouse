package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.OutputProduct;
import com.example.appwarehouse.payload.OutputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.OutputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

    @PostMapping
    public Result addOutputProduct(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.addOutputProduct(outputProductDto);
    }

    @GetMapping
    public List<OutputProduct> getOutputProduct(){
        return outputProductService.getOutputProduct();
    }

    @GetMapping("{id}")
    public OutputProduct getOutputProductById(@PathVariable Integer id){
        return outputProductService.getOutputProductById(id);
    }

    @PutMapping("{id}")
    public Result editOutputProductById(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto){
        return outputProductService.editOutputProductById(id,outputProductDto);
    }
}
