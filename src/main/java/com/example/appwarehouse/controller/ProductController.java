package com.example.appwarehouse.controller;


import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.payload.ProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.ProductService;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);

    }
    @GetMapping
    public List<Product> getProduct(){
        return productService.getProduct();
    }
    @GetMapping("{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);

    }
}
