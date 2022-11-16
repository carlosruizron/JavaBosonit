package com.example.block7crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="getById/{id}")
    public User getUserById(@PathVariable int id) throws FileNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping(value="getByName/{name}")
    public User getUserByName(@PathVariable String name) throws Exception {
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
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
