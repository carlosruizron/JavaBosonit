package com.example.block7crud.service;

import com.example.block7crud.entity.User;
import com.example.block7crud.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

//Creamos la interfaz de servicio para definir los métodos que vamos a utilizar en ServiceImpl
@Service
public interface UserService {

    User createUser(User user);
    User updateUser(User user);

    User getUserById(Integer id) throws UserNotFoundException;

    List<User> getUserByName(String name);
    void deleteUser(Integer id);

    Iterable findAll();
}
