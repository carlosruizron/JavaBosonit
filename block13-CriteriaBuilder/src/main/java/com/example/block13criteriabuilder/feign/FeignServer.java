package com.example.block13criteriabuilder.feign;

import com.example.block13criteriabuilder.person.infrastucture.dto.DtoTeacherPerson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "FeignServer", url = "http://localhost:8080")
public interface FeignServer {

    @GetMapping("/person/{id}")
    DtoTeacherPerson readTeacherById(@PathVariable("id") Integer id, @RequestParam(name = "outputType", defaultValue = "full") String type);
}
