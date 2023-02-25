package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.User;
import uz.pdp.apppwarehouse.entity.UserWarehouse;
import uz.pdp.apppwarehouse.entity.Warehouse;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.payload.UserWarehouseDto;
import uz.pdp.apppwarehouse.repository.UserRepository;
import uz.pdp.apppwarehouse.repository.UserWarehouseRepository;
import uz.pdp.apppwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserWarehouseService {
    @Autowired
    UserWarehouseRepository userWarehouseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addUserWarehouse(UserWarehouseDto userWarehouseDto){
        Optional<User> optionalUser = userRepository.findById(userWarehouseDto.getUserId());
        if (!optionalUser.isPresent())
            return new Result("Bunday user mavjud emas",false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userWarehouseDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas",false);
        UserWarehouse userWarehouse=new UserWarehouse();
        userWarehouse.setUser(optionalUser.get());
        userWarehouse.setWarehouse(optionalWarehouse.get());
        userWarehouseRepository.save(userWarehouse);
        return new Result("Muvaffaqiyatli qo'shildi",true);
    } public Result editUserWarehouse(UserWarehouseDto userWarehouseDto,Integer id){
        Optional<UserWarehouse> optionalUserWarehouse = userWarehouseRepository.findById(id);
        if (optionalUserWarehouse.isPresent()){
        Optional<User> optionalUser = userRepository.findById(userWarehouseDto.getUserId());
        if (!optionalUser.isPresent())
            return new Result("Bunday user mavjud emas",false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userWarehouseDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas",false);
        UserWarehouse userWarehouse=new UserWarehouse();
        userWarehouse.setUser(optionalUser.get());
        userWarehouse.setWarehouse(optionalWarehouse.get());
        userWarehouseRepository.save(userWarehouse);
        return new Result("Muvaffaqiyatli O'zgardi",true);
    }return new Result("Topilmadi",false);
    }public Result deleteUserWarehouse(Integer id){
        userWarehouseRepository.deleteById(id);
        return new Result("Deleted",false);
    }
    public List<UserWarehouse>getUserWarehouses(){
        List<UserWarehouse>userWarehouseList=userWarehouseRepository.findAll();
        return userWarehouseList;
    }

}
