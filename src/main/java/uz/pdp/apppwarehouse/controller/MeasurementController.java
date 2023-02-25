package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Client;
import uz.pdp.apppwarehouse.entity.Measurement;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.MeasurementService;

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
    } @PutMapping
    public Result editMeasurement(@RequestBody Measurement measurement, @PathVariable Integer id){
        Result result = measurementService.editMeasurement(measurement, id);
        return result;
    }@DeleteMapping
    public Result deleteMeasurement(@PathVariable Integer id){
        Result result = measurementService.deleteMeasurement(id);
        return result;
    }@GetMapping
    public List<Measurement> getMeasurement(){
        List<Measurement> measurementList = measurementService.getMeasurement();
        return measurementList;
    }
}
