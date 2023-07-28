package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Client;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public Result addClient(@RequestBody Client client){
       return clientService.addClient(client);
    }

    @GetMapping
    public List<Client> getClient(){
        return clientService.getClient();
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable Integer id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("{id}")
    public Result deleteClientById(@PathVariable Integer id){
        return clientService.deleteClientById(id);
    }

    @PutMapping("{id}")
    public Result editClientById(@PathVariable Integer id, @RequestBody Client client){
        return clientService.editClientById(id,client);
    }


}
