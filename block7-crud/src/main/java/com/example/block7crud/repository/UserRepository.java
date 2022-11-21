package com.example.block7crud.repository;

import com.example.block7crud.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Creamos la interfaz repositorio en la cual extendemos la interfaz CrudRepository
// Esta interfaz extendida ya contiene métodos con su lógica necesaria
public interface UserRepository extends CrudRepository<User,Integer> {

    // Usando la lógica y potencial de JPA y SPRING podemos crear este método para buscar por nombre
    List<User> findByName(String name);

}
