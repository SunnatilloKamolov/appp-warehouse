package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Input;
import uz.pdp.apppwarehouse.payload.InputDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;
    @PostMapping
    public Result addInput(@RequestBody InputDto inputDto){
        Result result = inputService.addInput(inputDto);
        return result;
    }@PutMapping
    public Result editInput(@RequestBody InputDto inputDto,@PathVariable Integer id){
        Result result = inputService.editInput(inputDto, id);
        return result;
    }@DeleteMapping
    public Result deleteInput(@PathVariable Integer id){
        Result result = inputService.deleteInput(id);
        return result;
    }
    @GetMapping
    public List<Input>getInput(){
        return inputService.getInputs();
    }
}
