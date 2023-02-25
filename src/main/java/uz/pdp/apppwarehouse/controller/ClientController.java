package uz.pdp.apppwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppwarehouse.entity.Client;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
  @PostMapping
    public Result addClient(@RequestBody Client client){
      Result result = clientService.addClient(client);
      return result;
  }
  @PutMapping
    public Result editClient(@RequestBody Client client,@PathVariable Integer id){
      Result result = clientService.editClient(client, id);
      return result;
  }@DeleteMapping
    public Result deleteClient(@PathVariable Integer id){
        Result result = clientService.deleteClient(id);
        return result;
    }@GetMapping
    public List<Client>getClients(){
        List<Client> clients = clientService.getClients();
        return clients;
    }

}
