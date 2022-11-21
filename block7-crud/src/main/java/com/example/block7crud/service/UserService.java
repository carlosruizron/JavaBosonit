package com.example.block7crud.service;

import com.example.block7crud.entity.User;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

//Creamos la interfaz de servicio para definir los métodos que vamos a utilizar en ServiceImpl
@Service
public interface UserService {

    User createUser(User user);
    User updateUser(User user);

    User getUserById(Integer id) throws FileNotFoundException;

    User getUserByName(String name) throws FileNotFoundException;
    void deleteUser(Integer id);
}
