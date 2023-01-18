package com.example.block16springcloud.client.infrastucture.controller;

import com.example.block16springcloud.client.application.impls.ClientServiceImpl;
import com.example.block16springcloud.client.infrastucture.dto.DtoClientInp;
import com.example.block16springcloud.client.infrastucture.dto.DtoClientOut;
import com.example.block16springcloud.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @PostMapping
    public DtoClientOut createClient(@RequestBody DtoClientInp dtoClientInp) {
        return clientService.createClient(dtoClientInp);
    }

    @PutMapping("/{id}")
    public DtoClientOut updateClient(@PathVariable Integer id, @RequestBody DtoClientInp dtoClientInp) throws EntityNotFoundException {
        return clientService.updateClient(id, dtoClientInp);
    }

    @GetMapping("/{id}")
    public DtoClientOut getById(@PathVariable Integer id) throws EntityNotFoundException {
        return clientService.getById(id);
    }

    @GetMapping
    public List<DtoClientOut> getAll() {

        return clientService.getAll();
    }

    @DeleteMapping("{id}")
    public String deleteClient(@PathVariable Integer id) {

        return clientService.deleteClient(id);
    }
}
