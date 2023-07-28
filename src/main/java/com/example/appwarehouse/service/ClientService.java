package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Client;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client) {
        Client client1 = new Client();
        client1.setName(client.getName());
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new Result("Client muvaffaqiyatli saqlandi",true,client1.getId());
    }

    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id) {
        Optional<Client> byId = clientRepository.findById(id);
        return byId.orElse(null);
    }

    public Result deleteClientById(Integer id) {
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isPresent()){
            clientRepository.deleteById(id);
            return new Result("Client o`chirildi",true);
        }return new Result("Bunday Id li client mavjud emas",false);
    }

    public Result editClientById(Integer id, Client client) {
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isEmpty())
            return new Result("BundayId li client mavjud emas",false);
        Client client1 = byId.get();
        client1.setName(client.getName());
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new Result("Client o`zgartirildi",true);
    }
}
