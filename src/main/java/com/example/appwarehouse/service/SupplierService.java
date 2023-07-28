package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result addSupplier(Supplier supplier) {
        Supplier supplier1 = new Supplier();
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplier1);
        return new Result("Taminotchi saqlandi",true,supplier1.getId());
    }

    public List<Supplier> getSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isPresent()) {
            Supplier supplier = byId.get();
            return supplier;
        }return null;
    }

    public Result deleteSupplierById(Integer id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isPresent()) {
            supplierRepository.deleteById(id);
            return new Result("Taminotchi o`chirildi", true);
        }return new Result("Bunday Id li taminotchi yo`q",false);
    }

    public Result editSupplierById(Integer id, Supplier supplier) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isPresent()){
            Supplier supplier1 = byId.get();
            supplier1.setName(supplier.getName());
            supplier1.setPhoneNumber(supplier1.getPhoneNumber());
            supplierRepository.save(supplier1);
            return new Result("Taminotchi o`zgartirildi",true,supplier1.getId());
        }return new Result("Bunday Id li tamintochi mavjud emas",false);
    }
}
