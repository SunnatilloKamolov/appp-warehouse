package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.Warehouse;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;
    public Result addWarehouse(Warehouse warehouse){
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("Bunday Warehouse mavjud ",false);
        warehouseRepository.save(warehouse);
        return new Result("Muvaffaqiyatli qo'shildi",true);
    }public Result editWarehouse(Warehouse warehouse,Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()){
            Warehouse warehouse1 = optionalWarehouse.get();
            warehouse1.setName(warehouse.getName());
            warehouseRepository.save(warehouse1);
            return new Result("Warehouse edited",true);
        }return new Result("Not found",false);
    }public Result deleteWarehouse(Integer id){
        warehouseRepository.deleteById(id);
        return new Result("deleted",true);
    }
    public List<Warehouse>getWarehouses(){
        List<Warehouse>warehouseList=warehouseRepository.findAll();
        return warehouseList;
    }
}
