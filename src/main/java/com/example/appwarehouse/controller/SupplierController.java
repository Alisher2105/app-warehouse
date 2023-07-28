package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.SupplierRepository;
import com.example.appwarehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping
    public Result addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    @GetMapping
    public List<Supplier> getSupplier(){
        return supplierService.getSupplier();
    }

    @GetMapping("{id}")
    public Supplier getSupplierById(@PathVariable Integer id){
        return supplierService.getSupplierById(id);
    }

    @DeleteMapping("{id}")
    public Result deleteSupplierById(@PathVariable Integer id){
        return supplierService.deleteSupplierById(id);
    }

    @PutMapping("{id}")
    public Result editSupplierById(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.editSupplierById(id,supplier);
    }
}
