package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse){
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName(warehouse.getName());
        warehouseRepository.save(warehouse1);
        return new Result("Ombor muvaffaqiyatli saqlandi",true,warehouse1.getId());
    }

    public List<Warehouse> getWarehouse() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(Integer id) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        return byId.orElse(null);
    }

    public Result deleteWarehouseById(Integer id) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if (byId.isEmpty())
            return new Result("Bunday Id li ombor yo`q",false);
        warehouseRepository.deleteById(id);
        return new Result("Muvaffaqiyatli o`chirildi",true);
    }

    public Result editUserById(Integer id, Warehouse warehouse) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if (byId.isEmpty())
            return new Result("Bunday Id li warehouse yo`q",false);
        Warehouse warehouse1 = byId.get();
        warehouse1.setName(warehouse.getName());
        warehouseRepository.save(warehouse1);
        return new Result("Muvaffaqiyatli o`zgartirildi",true,warehouse1.getId());
    }
}
