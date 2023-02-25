package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Client;
import uz.pdp.apppwarehouse.entity.Currency;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @PostMapping
    public Result addCurrency(@RequestBody Currency currency){
        Result result = currencyService.addCurrency(currency);
        return result;
    } @PutMapping
    public Result editCurrency(@RequestBody Currency currency, @PathVariable Integer id){
        Result result = currencyService.editCurrency(currency, id);
        return result;
    }@DeleteMapping
    public Result deleteCurrency(@PathVariable Integer id){
        Result result = currencyService.deleteCurrency(id);
        return result;
    }@GetMapping
    public List<Currency> getClients(){
        List<Currency> currencyList = currencyService.getCurrencies();
        return currencyList;
    }
}
