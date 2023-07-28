package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Measurement;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement){
        Result result = measurementService.addMeasurementService(measurement);
        return result;
    }

    @GetMapping
    public List<Measurement> getMeasurement(){
        return  measurementService.getMeasurement();
    }

    @GetMapping("{id}")
    public Measurement getMeasurementById(@PathVariable Integer id){
       return  measurementService.getMeasurementServiceById(id);
    }

    @DeleteMapping("{id}")
    public Result deleteMeasurementById(@PathVariable Integer id){
        return measurementService.deleteMeasurementById(id);
    }

    @PutMapping("{id}")
    public Result editMeasurementById(@PathVariable Integer id, @RequestBody Measurement measurement){
        return measurementService.editMeasurementServiceById(id, measurement);
    }

}
