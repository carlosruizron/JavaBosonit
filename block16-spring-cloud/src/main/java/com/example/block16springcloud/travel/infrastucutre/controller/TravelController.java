package com.example.block16springcloud.travel.infrastucutre.controller;

import com.example.block16springcloud.client.application.repository.ClientRepository;
import com.example.block16springcloud.client.domain.Client;
import com.example.block16springcloud.exception.EntityNotFoundException;
import com.example.block16springcloud.travel.application.impls.TravelServiceImpl;
import com.example.block16springcloud.travel.application.respository.TravelRepository;
import com.example.block16springcloud.travel.domain.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    TravelServiceImpl travelService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TravelRepository travelRepository;

    @PostMapping
    public Travel createTravel(@RequestBody Travel travel) {
        travelService.createTravel(travel);
        return travel;
    }

    @PutMapping("/addPassenger/{idClient}/{idTravel}")
    public String addPassengerToTrip(@PathVariable("idClient") Integer idClient, @PathVariable("idTravel") Integer idTravel) {

        Travel travel = travelService.readTravel(idTravel);
        System.out.println(travel.getClient().size());
        if (travel.getClient().size() >= 40) {
            System.out.println("No se admiten más personas");
            return "No se admiten más personas";
        }

        Client passenger = clientRepository.findById(idClient).orElseThrow(()-> new EntityNotFoundException("No se ha encontrado el id " + idClient));
        List<Client> listPassenger = travel.getClient();
        listPassenger.add(passenger);
        travel.setClient(listPassenger);
        travelRepository.save(travel);

        return "Añadido pasajero ID " + idClient + " a viaje ID " + idTravel;
    }

    @GetMapping("{id}")
    public Travel readTravel(@PathVariable("id") Integer idTravel) {
        return travelService.readTravel(idTravel);
    }

    @GetMapping("/verify/{id}")
    public String verifyTrip(@PathVariable("id") Integer idTravel) {
        return "El estado del viaje con el id " + idTravel + " es: " + travelService.verify(idTravel);
    }

    @GetMapping
    public List<Travel> readAllTravel() {
        return travelService.readAllTravel();
    }

    @PutMapping("{id}")
    public Travel updateTravel(@PathVariable("id") Integer id, @RequestBody Travel travel1) {

        return travelService.updateTravel(id, travel1);
    }

    @PutMapping("/{id}/{status}")
    public String updateState(@PathVariable("id") Integer idTravel, @PathVariable("status") String status) {
        travelService.updateStatusTravel(idTravel, status);
        return "El estado del autobús se ha cambiado a: " + status;
    }

    @DeleteMapping("/{id}")
    public String deleteTrip(@PathVariable("id") Integer idTravel) {

       return travelService.deleteTravel(idTravel);
    }
}
