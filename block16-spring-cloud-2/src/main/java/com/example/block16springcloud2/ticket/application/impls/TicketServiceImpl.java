package com.example.block16springcloud2.ticket.application.impls;

import com.example.block16springcloud2.client.Client;
import com.example.block16springcloud2.exception.EntityNotFoundException;
import com.example.block16springcloud2.ticket.application.interfaces.TicketService;
import com.example.block16springcloud2.ticket.domain.Ticket;
import com.example.block16springcloud2.ticket.infrastructure.repository.TicketRepository;
import com.example.block16springcloud2.travel.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Client client, Travel travel) {

        Ticket ticket = new Ticket(client, travel);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket readTicketById(Integer id) {

        return ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el id: " + id));
    }

    @Override
    public List<Ticket> readAllTickets() {

        return ticketRepository.findAll();
    }

    @Override
    public Ticket updateTicket(Integer id, Ticket ticket1) {

        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el id: " + id));
        ticket.update(ticket1);
        return ticketRepository.save(ticket);
    }

    @Override
    public String deleteTicket(Integer id) {

        ticketRepository.deleteById(id);
        return "Se ha borrado el ticket con el id: " + id;
    }
}
