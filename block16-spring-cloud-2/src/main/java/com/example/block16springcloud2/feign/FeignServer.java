package com.example.block16springcloud2.feign;

import com.example.block16springcloud2.client.Client;
import com.example.block16springcloud2.travel.Travel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticketFeign", url = "http://localhost:8080")
public interface FeignServer {

    @GetMapping("/client/{id}")
    Client readClientById(@PathVariable("id") Integer idClient);

    @GetMapping("/travel/{id}")
    Travel readTravelById(@PathVariable("id") Integer idTravel);

}
