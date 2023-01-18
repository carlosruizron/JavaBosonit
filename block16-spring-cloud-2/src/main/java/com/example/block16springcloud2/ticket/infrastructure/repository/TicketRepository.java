package com.example.block16springcloud2.ticket.infrastructure.repository;

import com.example.block16springcloud2.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
