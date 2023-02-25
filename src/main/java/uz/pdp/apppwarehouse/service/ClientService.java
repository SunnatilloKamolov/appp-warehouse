package uz.pdp.apppwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppwarehouse.entity.Client;
import uz.pdp.apppwarehouse.payload.Result;
import uz.pdp.apppwarehouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client) {
        boolean exists = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (exists)
           return new Result("Bunday client mavjud", false);
        clientRepository.save(client);
        return new Result("Muvaffaqiyatli qo'shildi",true);
    }public Result editClient(Client client,Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            Client client1 = optionalClient.get();
            client1.setName(client.getName());
            clientRepository.save(client1);
            return new Result("Client edited",true);
        }return new Result("Client not found",false);
    }public Result deleteClient(Integer id){
        clientRepository.deleteById(id);
        return new Result("Deleted",true);
    }public List<Client>getClients(){
        List<Client>clientList=clientRepository.findAll();
        return clientList;
    }
}
