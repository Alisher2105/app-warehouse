package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.payload.InputDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService inputService;

    @PostMapping
    public Result addInput(@RequestBody InputDto inputDto){
        return inputService.addInput(inputDto);
    }

    @GetMapping
    public List<Input> getInput(){
        return inputService.getInput();
    }

    @GetMapping("{id}")
    public Input getInputById(@PathVariable Integer id){
        return inputService.getInputById(id);
    }

    @PutMapping("{id}")
    public Result editInputById(@PathVariable Integer id, @RequestBody InputDto inputDto){
        return inputService.editInputById(id,inputDto);
    }
}
