package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping
    public Result addWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.addWarehouse(warehouse);
    }

    @GetMapping
    public List<Warehouse> getWarehouse(){
        return warehouseService.getWarehouse();
    }

    @GetMapping("{id}")
    public Warehouse getWarehouseById(@PathVariable Integer id){
       return warehouseService.getWarehouseById(id);
    }

    @DeleteMapping("{id}")
    public Result deleteWarehouseById(@PathVariable Integer id){
         return warehouseService.deleteWarehouseById(id);
    }

    @PutMapping("{id}")
    public Result editUserById(@PathVariable Integer id,@RequestBody Warehouse warehouse){
        return warehouseService.editUserById(id,warehouse);
    }

}
