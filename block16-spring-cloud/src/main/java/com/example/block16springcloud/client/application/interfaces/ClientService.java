package com.example.block16springcloud.client.application.interfaces;

import com.example.block16springcloud.client.infrastucture.dto.DtoClientInp;
import com.example.block16springcloud.client.infrastucture.dto.DtoClientOut;
import com.example.block16springcloud.exception.EntityNotFoundException;
import com.example.block16springcloud.exception.UnprocessableEntityException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    DtoClientOut createClient(DtoClientInp dtoClientInp) throws UnprocessableEntityException;
    DtoClientOut updateClient(Integer id, DtoClientInp dtoClientInp) throws EntityNotFoundException, UnprocessableEntityException;
    String deleteClient(Integer id) throws EntityNotFoundException;
    DtoClientOut getById(Integer id) throws EntityNotFoundException;
    List<DtoClientOut> getAll();

}
