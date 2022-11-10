package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Configuration
public class Controller_bean {

    @Autowired
    @Qualifier("bean2")
    Person2 bean1;

//    @Autowired
//    @Qualifier("bean2")
//    Person2 bean2;
//
//    @Autowired
//    @Qualifier("bean3")
//    Person2 bean3;


    @GetMapping("controller/bean/{bean}")
    public String getBean() {
        return bean1.getName();
    }


//    @GetMapping("controller/bean/{bean}")
//    public String getBean(@PathVariable("bean") String check) {
//
//        String result;
//
//        if(check == "bean1") {
//            result = bean1.getName() + " " + bean1.getCity() + " " + bean1.getAge();
//        }
//        else if(check == "bean2") {
//            result = bean2.getName() + " " + bean2.getCity() + " " + bean2.getAge();
//        }
//        else if(check == "bean3"){
//            result = bean3.getName() + " " + bean3.getCity() + " " + bean3.getAge();
//        }
//        else {
//            result = "No existe este usuario";
//            System.out.println(check);
//        }
//
//        return result;
//    }

}
