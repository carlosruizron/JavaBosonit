package com.example.block7crudvalidation.feign;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "FeignServer", url = "http://localhost:8080")
public interface FeignServer {

    @GetMapping("/teacher/{id}")
    Teacher readTeacherById(@PathVariable("id") Integer id);
}
