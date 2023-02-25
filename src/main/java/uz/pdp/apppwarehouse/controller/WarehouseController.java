package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Supplier;
import uz.pdp.apppwarehouse.entity.Warehouse;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    public Result addWarehouse(@RequestBody Warehouse warehouse){
        Result result = warehouseService.addWarehouse(warehouse);
        return result;
    }@PutMapping
    public Result editWarehouse(@RequestBody Warehouse warehouse, @PathVariable Integer id){
        Result result = warehouseService.editWarehouse(warehouse, id);
        return result;
    }@DeleteMapping
    public Result deleteWarehouse(@PathVariable Integer id){
        Result result = warehouseService.deleteWarehouse(id);
        return result;
    }
    @GetMapping
    public List<Warehouse> getWarehouse(){
        return warehouseService.getWarehouses();
    }

}
