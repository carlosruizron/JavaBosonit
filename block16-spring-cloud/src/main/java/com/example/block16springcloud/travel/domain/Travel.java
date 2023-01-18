package com.example.block16springcloud.travel.domain;

import com.example.block16springcloud.client.domain.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Travel implements Serializable {

    @Id
    @GeneratedValue
    Integer idTrip;

    @Column
    String origin;

    @Column
    String destination;

    @Column
    Date departureDate;

    @Column
    Date arrivalDate;

    @OneToMany
    @JoinColumn
    List<Client> client;

    @Column
    String status;

    public void update(Travel travel) {
        if(travel.getOrigin() != null) {
            setOrigin(travel.getOrigin());
        }
        if(travel.getDestination() != null) {
            setDestination(travel.getDestination());
        }
        if(travel.getDepartureDate() != null) {
            setDepartureDate(travel.getDepartureDate());
        }
        if(travel.getArrivalDate() != null) {
            setArrivalDate(travel.getArrivalDate());
        }
        if(travel.getStatus() != null) {
            setStatus(travel.getStatus());
        }
    }
}
