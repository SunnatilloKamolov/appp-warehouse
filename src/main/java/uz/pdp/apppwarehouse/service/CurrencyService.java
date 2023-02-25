package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apppwarehouse.entity.Client;
import uz.pdp.apppwarehouse.entity.Currency;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
    public Result addCurrency(Currency currency){
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName)
            return new Result("Bunday currency mavjud",false);
        currencyRepository.save(currency);
        return new Result("Muvaffaqiyatli qo'shildi",true);
    }public Result editCurrency(Currency currency, Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()){
            Currency currency1 = optionalCurrency.get();
            currency1.setName(currency1.getName());
           currencyRepository.save(currency1);
            return new Result("Currency edited",true);
        }return new Result("Currency not found",false);
    }public Result deleteCurrency(Integer id){
        currencyRepository.deleteById(id);
        return new Result("Deleted",true);
    }public List<Currency> getCurrencies(){
        List<Currency>currenciesList=currencyRepository.findAll();
        return currenciesList;
    }
}
