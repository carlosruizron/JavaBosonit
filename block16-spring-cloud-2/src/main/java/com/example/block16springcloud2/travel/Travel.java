package com.example.block16springcloud2.travel;

import com.example.block16springcloud2.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

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
}
