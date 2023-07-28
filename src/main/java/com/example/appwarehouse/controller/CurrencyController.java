package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Currency;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public Result addCurrency(@RequestBody Currency currency){
        return currencyService.addCurrency(currency);
    }

    @GetMapping
    public List<Currency> getCurrency(){
        return currencyService.getCurrency();
    }

    @GetMapping("{id}")
    public Currency getCurrencyById(@PathVariable Integer id){
        return currencyService.getCurrencyById(id);
    }

    @DeleteMapping("{id}")
    public Result deleteCurrencyById(@PathVariable Integer id){
        return currencyService.deleteCurrencyById(id);
    }

    @PutMapping("{id}")
    public Result editCurrencyById(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.editCurrencyById(id, currency);
    }
}
