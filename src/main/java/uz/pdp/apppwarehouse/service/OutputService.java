package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.Client;
import uz.pdp.apppwarehouse.entity.Currency;
import uz.pdp.apppwarehouse.entity.Output;
import uz.pdp.apppwarehouse.entity.Warehouse;
import uz.pdp.apppwarehouse.payload.OutputDto;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.ClientRepository;
import uz.pdp.apppwarehouse.repository.CurrencyRepository;
import uz.pdp.apppwarehouse.repository.OutputRepository;
import uz.pdp.apppwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addOutput(OutputDto outputDto) {
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (!optionalClient.isPresent())
            return new Result("Bunday client mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas", false);

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas", false);

        Output output = new Output();
        output.setDate(outputDto.getDate());
        output.setCode(output.getCode());
        output.setFactureNumber(output.getFactureNumber());
        output.setCurrency(optionalCurrency.get());
        output.setWarehouse(optionalWarehouse.get());
        output.setClient(optionalClient.get());
        outputRepository.save(output);
        return new Result("Muvaffaqiyatli qo'shildi", true);
    }

    public Result editOutput(OutputDto outputDto, Integer id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isPresent()) {
            Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
            if (!optionalClient.isPresent())
                return new Result("Bunday client mavjud emas", false);

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
            if (!optionalWarehouse.isPresent())
                return new Result("Bunday warehouse mavjud emas", false);

            Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
            if (!optionalCurrency.isPresent())
                return new Result("Bunday currency mavjud emas", false);

            Output output = new Output();
            output.setDate(outputDto.getDate());
            output.setCode(output.getCode());
            output.setFactureNumber(output.getFactureNumber());
            output.setCurrency(optionalCurrency.get());
            output.setWarehouse(optionalWarehouse.get());
            output.setClient(optionalClient.get());
            outputRepository.save(output);
            return new Result("Muvaffaqiyatli O'zgartirildi", true);
        }
        return new Result("O'zgartirilmadi", false);
    }

    public Result deleteOutput(Integer id) {
        outputRepository.deleteById(id);
        return new Result("Deleted", true);
    }
    public List<Output>getOutputs(){
        List<Output>outputList=outputRepository.findAll();
        return outputList;
    }
}
