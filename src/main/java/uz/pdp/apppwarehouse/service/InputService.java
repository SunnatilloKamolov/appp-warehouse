package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.*;
import uz.pdp.apppwarehouse.payload.InputDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.CurrencyRepository;
import uz.pdp.apppwarehouse.repository.InputRepository;
import uz.pdp.apppwarehouse.repository.SupplierRepository;
import uz.pdp.apppwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    public Result addInput(InputDto inputDto){
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas",false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if ((!optionalWarehouse.isPresent()))
            return new Result("Bunday warehouse mavjud emas",false);

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent())
            return new Result("Bunday supplier mavjud emas",false);

        Input input=new Input();
        input.setDate(inputDto.getDate());
        input.setCode(inputDto.getCode());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());
        input.setWarehouse(optionalWarehouse.get());
        inputRepository.save(input);
        return new Result("Muvaffaqiyatli qo'shildi",true);
    }public Result editInput(InputDto inputDto,Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()){
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas",false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if ((!optionalWarehouse.isPresent()))
            return new Result("Bunday warehouse mavjud emas",false);

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent())
            return new Result("Bunday supplier mavjud emas",false);
            Input input=new Input();
            input.setDate(inputDto.getDate());
            input.setCode(inputDto.getCode());
            input.setFactureNumber(inputDto.getFactureNumber());
            input.setSupplier(optionalSupplier.get());
            input.setCurrency(optionalCurrency.get());
            input.setWarehouse(optionalWarehouse.get());
            inputRepository.save(input);
            return new Result("Muvaffaqiyatli o'zgartirildi",true);
    }return new Result("Input not found",false);
    }
    public Result deleteInput(Integer id){
        inputRepository.deleteById(id);
        return new Result("Deleted",true);
    }public List<Input>getInputs(){
        List<Input>inputList=inputRepository.findAll();
        return inputList;
    }
}
