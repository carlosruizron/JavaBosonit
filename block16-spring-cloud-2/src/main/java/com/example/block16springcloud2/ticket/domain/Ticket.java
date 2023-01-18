package com.example.block16springcloud2.ticket.domain;

import com.example.block16springcloud2.client.Client;
import com.example.block16springcloud2.travel.Travel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    private Integer idTicket;

    @Column
    private Integer idClient;

    @Column
    private String clientName;

    @Column
    private String clientLastName;

    @Column
    private String clientEmail;

    @Column
    private String travelOrigin;

    @Column
    private String travelDestination;

    @Column
    private Date departureDate;

    @Column
    private Date arrivalDate;

    public Ticket(Client client, Travel travel) {

        this.setIdClient(client.getIdClient());
        this.setClientName(client.getFirstName());
        this.setClientLastName(client.getLastName());
        this.setClientEmail(client.getEmail());
        this.setTravelOrigin(travel.getOrigin());
        this.setTravelDestination(travel.getDestination());
        this.setDepartureDate(travel.getDepartureDate());
        this.setArrivalDate(travel.getArrivalDate());
    }

    public void update(Ticket ticket) {
        if(ticket.getClientName() != null) {
            setClientName(ticket.getClientName());
        }
        if(ticket.getClientLastName() != null) {
            setClientLastName(ticket.getClientLastName());
        }
        if(ticket.getClientEmail() != null) {
            setClientEmail(ticket.getClientEmail());
        }
        if(ticket.getTravelOrigin() != null) {
            setTravelOrigin(ticket.getTravelOrigin());
        }
        if(ticket.getTravelDestination() != null) {
            setTravelDestination(ticket.getTravelDestination());
        }
        if(ticket.getDepartureDate() != null) {
            setDepartureDate(ticket.getDepartureDate());
        }
        if(ticket.getArrivalDate() != null) {
            setArrivalDate(ticket.getArrivalDate());
        }

    }
}
