package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.entity.Supplier;
import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.InputDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.CurrencyRepository;
import com.example.appwarehouse.repository.InputRepository;
import com.example.appwarehouse.repository.SupplierRepository;
import com.example.appwarehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addInput(InputDto inputDto) {

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new Result("Bunday Id li ombor mavju emas",false);

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (optionalSupplier.isEmpty())
            return new Result("Bynday Id li taminotchi mavjud emas",false);

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new Result("Bunday Id li pul birligi mavjud emas",false);

        Input input = new Input();
        input.setDate(inputDto.getDate());
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode(inputDto.getCode());
        inputRepository.save(input);
        return new Result("Kirim saqlandi",true,input.getId());
    }

    public List<Input> getInput() {
        return inputRepository.findAll();
    }

    public Input getInputById(Integer id) {
        Optional<Input> byId = inputRepository.findById(id);
        return byId.orElse(null);
    }

    public Result editInputById(Integer id, InputDto inputDto) {

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new Result("Bunday Id li Ombor mavjud emas",false);

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (optionalSupplier.isEmpty())
            return new Result(" Bunday Id li Taminotchi mavjud emas",false);

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new Result("Bunday Idli Pul birligi mavjud emas",false);
        Input input = inputRepository.findById(id).get();
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setDate(inputDto.getDate());
        input.setCode(inputDto.getCode());
        inputRepository.save(input);
        return new Result("Kirim O`zgartirildi",true,input.getId());
    }
}
