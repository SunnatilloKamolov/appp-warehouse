package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.User;
import uz.pdp.apppwarehouse.entity.UserWarehouse;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.payload.UserWarehouseDto;
import uz.pdp.apppwarehouse.service.UserWarehouseService;

import java.util.List;

@RestController
@RequestMapping("/userWarehouse")
public class UserWarehouseController {
    @Autowired
    UserWarehouseService userWarehouseService;
   public Result addUserWarehouse(@RequestBody UserWarehouseDto userWarehouseDto){
       Result result = userWarehouseService.addUserWarehouse(userWarehouseDto);
       return result;
   }@PutMapping
    public Result editUserWare(@RequestBody UserWarehouseDto userWarehouseDto, @PathVariable Integer id){
        Result result = userWarehouseService.editUserWarehouse(userWarehouseDto, id);
        return result;
    }@DeleteMapping
    public Result deleteUserWare(@PathVariable Integer id){
        Result result = userWarehouseService.deleteUserWarehouse(id);
        return result;
    }
    @GetMapping
    public List<UserWarehouse> getUserWare(){
        return userWarehouseService.getUserWarehouses();
    }
}
