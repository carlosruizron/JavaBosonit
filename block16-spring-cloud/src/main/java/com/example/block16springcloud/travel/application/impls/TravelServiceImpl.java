package com.example.block16springcloud.travel.application.impls;

import com.example.block16springcloud.exception.EntityNotFoundException;
import com.example.block16springcloud.travel.application.interfaces.TravelService;
import com.example.block16springcloud.travel.application.respository.TravelRepository;
import com.example.block16springcloud.travel.domain.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    TravelRepository travelRepository;

    @Override
    public Travel createTravel(Travel travel) {
        return travelRepository.save(travel);
    }

    @Override
    public Travel readTravel(Integer id) {
        return travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el id " + id));
    }

    @Override
    public Integer readTravelCount(Integer id) {
        Travel travel = travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el id " + id));
        return travel.getClient().size();
    }

    @Override
    public List<Travel> readAllTravel() {
        return travelRepository.findAll();
    }

    @Override
    public String verify(Integer id) {
        Travel travel = travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el id " + id));
        return travel.getStatus();
    }

    @Override
    public Travel updateTravel(Integer id, Travel travel) {
        Travel travel1 = travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Nop se ha encontrado el viaje con el id:" + id));
        travel1.update(travel);
        travelRepository.save(travel1);
        return travel1;
    }

    @Override
    public String updateStatusTravel(Integer id, String status) {
        Travel travel = travelRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se ha encontrado el id " + id));
        travel.setStatus(status);
        travelRepository.save(travel);
        return "El estado del autobús se ha cambiado a " + status;
    }

    @Override
    public String deleteTravel(Integer id) {
        travelRepository.deleteById(id);
        return "Se ha borrado correctamente el viaje con el id " + id;
    }
}
