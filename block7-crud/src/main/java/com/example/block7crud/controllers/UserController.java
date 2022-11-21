package com.example.block7crud.controllers;

import com.example.block7crud.entity.User;
import com.example.block7crud.exception.UserNotFoundException;
import com.example.block7crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

//En esta clase creamos los controladores para poder insertar, borrar o buscar información.
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="findAll")
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value="getById/{id}")
    public User getUserById(@PathVariable Integer id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping(value="getByName/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PostMapping(value="/insert")
    public User insertUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @PutMapping(value="/update")
    public User updateUser(@RequestBody User user) {

        return userService.updateUser(user);
    }

    @DeleteMapping(value="delete/{id}")
    public void deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);
    }

}
