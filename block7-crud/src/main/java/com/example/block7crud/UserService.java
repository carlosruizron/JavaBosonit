package com.example.block7crud;

import java.io.FileNotFoundException;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);

    User getUserById(int id) throws FileNotFoundException;

    User getUserByName(String name) throws FileNotFoundException;
    void deleteUser(int id);
}
