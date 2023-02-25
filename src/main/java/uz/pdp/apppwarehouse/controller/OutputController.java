package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Input;
import uz.pdp.apppwarehouse.entity.Output;
import uz.pdp.apppwarehouse.payload.InputDto;
import uz.pdp.apppwarehouse.payload.OutputDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;
    @PostMapping
    public Result addOutput(OutputDto outputDto){
        Result result = outputService.addOutput(outputDto);
        return result;
    }@PutMapping
    public Result editOutput(@RequestBody OutputDto outputDto, @PathVariable Integer id){
        Result result = outputService.editOutput(outputDto, id);
        return result;
    }@DeleteMapping
    public Result deleteInput(@PathVariable Integer id){
        Result result = outputService.deleteOutput(id);
        return result;
    }
    @GetMapping
    public List<Output> getInput(){
        return outputService.getOutputs();
    }
}
