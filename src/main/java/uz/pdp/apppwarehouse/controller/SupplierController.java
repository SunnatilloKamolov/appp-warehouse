package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Output;
import uz.pdp.apppwarehouse.entity.Supplier;
import uz.pdp.apppwarehouse.payload.OutputDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping
    public Result addSupplier(@RequestBody Supplier supplier){
        Result result = supplierService.addSupplier(supplier);
        return result;
    }@PutMapping
    public Result editSupplier(@RequestBody Supplier supplier, @PathVariable Integer id){
        Result result = supplierService.editSupplier(supplier, id);
        return result;
    }@DeleteMapping
    public Result deleteSupplier(@PathVariable Integer id){
        Result result = supplierService.deleteSupplier(id);
        return result;
    }
    @GetMapping
    public List<Supplier> getSupplier(){
        return supplierService.getSupplier();
    }
}
