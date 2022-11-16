package com.example.block7crud;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

//Creamos la interfaz repositorio en la cual extendemos la interfaz CrudRepository
// Esta interfaz extendida ya contiene métodos con su lógica necesaria
public interface UserRepository extends CrudRepository<User,Integer> {

    Optional<User> findByName(String name);

}
