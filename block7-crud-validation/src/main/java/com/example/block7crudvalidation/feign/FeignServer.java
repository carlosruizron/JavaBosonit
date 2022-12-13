package com.example.block7crudvalidation.feign;

import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonOut;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoTeacherPerson;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "FeignServer", url = "http://localhost:8080")
public interface FeignServer {

    @GetMapping("/person/{id}")
    DtoTeacherPerson readTeacherById(@PathVariable("id") Integer id, @RequestParam(name = "outputType", defaultValue = "full") String type);
}
