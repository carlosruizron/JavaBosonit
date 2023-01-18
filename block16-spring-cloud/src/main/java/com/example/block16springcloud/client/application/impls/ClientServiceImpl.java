package com.example.block16springcloud.client.application.impls;

import com.example.block16springcloud.client.application.interfaces.ClientService;
import com.example.block16springcloud.client.application.repository.ClientRepository;
import com.example.block16springcloud.client.domain.Client;
import com.example.block16springcloud.client.infrastucture.dto.DtoClientInp;
import com.example.block16springcloud.client.infrastucture.dto.DtoClientOut;
import com.example.block16springcloud.exception.EntityNotFoundException;
import com.example.block16springcloud.exception.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public DtoClientOut createClient(DtoClientInp dtoClientInp) throws UnprocessableEntityException {
        Client client = new Client(dtoClientInp);
        clientRepository.save(client);
        return new DtoClientOut(client);
    }

    @Override
    public DtoClientOut updateClient(Integer id, DtoClientInp dtoClientInp) throws EntityNotFoundException, UnprocessableEntityException {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con el id " + id + " no se encuentra"));
        client.update(dtoClientInp);
        clientRepository.save(client);
        return new DtoClientOut(client);
    }

    public String deleteClient(Integer id) throws EntityNotFoundException {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el id " + id));
        clientRepository.delete(client);
        return "Se ha borrado correctamente";
    }

    public DtoClientOut getById(Integer id) throws EntityNotFoundException {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el id " + id));
        DtoClientOut dtoClientOut = new DtoClientOut(client);
        return dtoClientOut;
    }

    @Override
    public List<DtoClientOut> getAll() {
        List<DtoClientOut> list = new ArrayList<>();
        clientRepository.findAll().forEach(client -> {
            DtoClientOut dtoClientOut = new DtoClientOut(client);
            list.add(dtoClientOut);
        });
        return list;
    }
}
