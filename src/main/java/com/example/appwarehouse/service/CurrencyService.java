package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addCurrency(Currency currency) {
        Currency currency1 = new Currency();
        currency1.setName(currency.getName());
        currencyRepository.save(currency1);
        return new Result("Pul birligi saqlandi",true);
    }

    public List<Currency> getCurrency() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Integer id) {
        Optional<Currency> byId = currencyRepository.findById(id);
        return byId.orElse(null);
    }

    public Result deleteCurrencyById(Integer id) {
        Optional<Currency> byId = currencyRepository.findById(id);
        if (byId.isPresent()){
            currencyRepository.deleteById(id);
            return new Result("Pul birligi o`chrildi",true);
        }return new Result("Bunday Id li pul birligi mavjud emas",false);
    }


    public Result editCurrencyById(Integer id, Currency currency) {
        Optional<Currency> byId = currencyRepository.findById(id);
        if (byId.isEmpty())
            return  new Result("Bunday Id li Pul birligi mavjud emas",false);
        Currency currency1 = byId.get();
        currency1.setName(currency.getName());
        currencyRepository.save(currency1);
        return new Result("Pul birligi o`zgartirildi",true,currency1.getId());
    }
}
