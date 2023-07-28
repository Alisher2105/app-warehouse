package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Output;
import com.example.appwarehouse.payload.OutputDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping
    public Result addOutput(@RequestBody OutputDto outputDto){
        return outputService.addOutput(outputDto);
    }

    @GetMapping
    public List<Output> getOutput(){
        return outputService.getOutput();
    }

    @GetMapping("{id}")
    public Output getOutputById(@PathVariable Integer id){
        return outputService.getOutputById(id);
    }

    @PutMapping("{id}")
    public Result editOutputById(@PathVariable Integer id, @RequestBody OutputDto outputDto){
        return outputService.editOutputById(id, outputDto);
    }

}
