package com.example.block16springcloud2.ticket.infrastructure.controller;

import com.example.block16springcloud2.client.Client;
import com.example.block16springcloud2.feign.FeignServer;
import com.example.block16springcloud2.ticket.application.impls.TicketServiceImpl;
import com.example.block16springcloud2.ticket.domain.Ticket;
import com.example.block16springcloud2.travel.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @Autowired
    FeignServer feignServer;

    @PostMapping("/{idClient}/{idTravel}")
    public Ticket createTicket(@PathVariable ("idClient") Integer idClient, @PathVariable("idTravel") Integer idTravel) {

        Client client = feignServer.readClientById(idClient);
        Travel travel = feignServer.readTravelById(idTravel);

        return ticketService.createTicket(client, travel);
    }

    @GetMapping("/{id}")
    public Ticket readTicketById(@PathVariable("id") Integer id) {

        return ticketService.readTicketById(id);
    }

    @GetMapping("/update/{id}")
    public Ticket updateTicket(@PathVariable("id") Integer id, @RequestBody Ticket ticket) {

        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable("id") Integer id) {

        return ticketService.deleteTicket(id);
    }



}
