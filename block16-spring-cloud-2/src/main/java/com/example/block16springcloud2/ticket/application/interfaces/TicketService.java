package com.example.block16springcloud2.ticket.application.interfaces;

import com.example.block16springcloud2.client.Client;
import com.example.block16springcloud2.ticket.domain.Ticket;
import com.example.block16springcloud2.travel.Travel;

import java.util.List;

public interface TicketService {

    Ticket createTicket(Client client, Travel travel);
    Ticket readTicketById(Integer idTicket);
    List<Ticket> readAllTickets();
    Ticket updateTicket(Integer id, Ticket ticket);
    String deleteTicket(Integer idTicket);
}
