package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Measurement;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    //ADD Measurement
    public Result addMeasurementService(Measurement measurement){

        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName) {
            return new Result("Bunday o`lchov bir ligi mavjud", false);
        }
        measurementRepository.save(measurement);
        return new Result("Muvaffaqiyatli saqlandi",true,measurement.getId());
    }

    // Read ALL
    public List<Measurement> getMeasurement(){
        return measurementRepository.findAll();
    }

    // Read By ID
    public Measurement getMeasurementServiceById(Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        return byId.orElse(null);
    }

    // Delete By ID
    public Result deleteMeasurementById(Integer id){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if(byId.isPresent()){
            measurementRepository.deleteById(id);
        return new Result("Measurement muvaffaqiyatli o`chirildi",true);
        }return new Result("Bynday id li Measurement yo`q",false);
    }

    // Edit By Id

    public Result editMeasurementServiceById(Integer id, Measurement measurement){
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isPresent()){
            Measurement measurement1 = byId.get();
            measurement1.setName(measurement.getName());
            measurementRepository.save(measurement1);
            return new Result("Muvaffaqiyatli o`zgartirildi",true);
        }return new Result("Bunday Measurement yo`q",false);
    }



}
