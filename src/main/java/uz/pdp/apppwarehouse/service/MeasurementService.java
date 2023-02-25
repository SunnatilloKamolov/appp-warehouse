package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.Measurement;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.MeasurementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;
    public Result addMeasurementService(Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("Bunday o'lchov birligi mavjud",false);
        measurementRepository.save(measurement);
        return new Result("Muvaffaqiyatli saqlandi",true);
    }public Result editMeasurement(Measurement measurement,Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            Measurement measurement1 = optionalMeasurement.get();
            measurement1.setName(measurement.getName());
            measurementRepository.save(measurement1);
            return new Result("edited",true);
        }return new Result("Not found",false);
    }public Result deleteMeasurement(Integer id){
        measurementRepository.deleteById(id);
        return new Result("deleted",true);
    }
    public List<Measurement>getMeasurement(){
        List<Measurement>measurementList=measurementRepository.findAll();
        return measurementList;
    }
}
