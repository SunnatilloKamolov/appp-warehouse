package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.Supplier;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    public Result addSupplier(Supplier supplier){
        boolean exists = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (exists)
            return new Result("Bunday supplier mavjud",false);
        supplierRepository.save(supplier);
        return new Result("Muvaffaqiyatli qo'shildi",true);
    }public Result editSupplier(Supplier supplier,Integer id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()){
            Supplier supplier1 = optionalSupplier.get();
            supplier1.setName(supplier.getName());
            supplierRepository.save(supplier);
            return new Result("Edited",true);
        }return new Result("Not found",false);
    }public Result deleteSupplier(Integer id){
        supplierRepository.deleteById(id);
        return new Result("Deleted",true);
    }
    public List<Supplier>getSupplier(){
        List<Supplier>supplierList=supplierRepository.findAll();
        return supplierList;
    }
}
