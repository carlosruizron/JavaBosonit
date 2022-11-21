package com.example.block7crud.service;

import com.example.block7crud.entity.User;
import com.example.block7crud.repository.UserRepository;
import com.example.block7crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

// En esta clase sobreescribimos los métodos definidos en la clase UserService
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Integer id) throws FileNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new FileNotFoundException(("Usuario no encontrado"))) ;
    }

    @Override
    public User getUserByName(String name) throws FileNotFoundException {
        return userRepository.findByName(name).orElseThrow(() -> new FileNotFoundException("No se ha encontrado el usuario " + name));
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


}
