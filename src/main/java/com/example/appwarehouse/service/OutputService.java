package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Client;
import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.entity.Output;
import com.example.appwarehouse.entity.Warehouse;
import com.example.appwarehouse.payload.OutputDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.ClientRepository;
import com.example.appwarehouse.repository.CurrencyRepository;
import com.example.appwarehouse.repository.OutputRepository;
import com.example.appwarehouse.repository.WarehouseRepository;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {

    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ClientRepository clientRepository;


    public Result addOutput(OutputDto outputDto) {

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new Result("Bunday Id li Ombor mavjud emas",false);

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new Result("Bunday Id li Pul birligi mavjud emas",false);

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (optionalClient.isEmpty())
            return new Result("Bunday Id li Client mavjud emas",false);

        Output output = new Output();
        output.setWarehouse(optionalWarehouse.get());
        output.setCurrency(optionalCurrency.get());
        output.setClient(optionalClient.get());
        output.setDate(outputDto.getDate());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setCode(outputDto.getCode());
        outputRepository.save(output);
        return new Result("Output saqlandi",true, output.getId());
    }

    public List<Output> getOutput(){
        return outputRepository.findAll();
    }

    public Output getOutputById(Integer id){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        return optionalOutput.orElse(null);
    }

    public Result editOutputById(Integer id, OutputDto outputDto){

        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isEmpty())
            return new Result("Bunday Id li Output mavjud emas",false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new Result("Bunday Id li Ombor mavjud emas",false);

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new Result("Bunday Id li Pul birligi mavjud emas",false);

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (optionalClient.isEmpty())
            return new Result("Bunday Id li Client mavjud emas",false);

        Output output = optionalOutput.get();
        output.setWarehouse(optionalWarehouse.get());
        output.setCurrency(optionalCurrency.get());
        output.setClient(optionalClient.get());
        output.setDate(outputDto.getDate());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setCode(outputDto.getCode());
        outputRepository.save(output);
        return new Result("Output o`zgartirildi", true,output.getId());



    }
}

