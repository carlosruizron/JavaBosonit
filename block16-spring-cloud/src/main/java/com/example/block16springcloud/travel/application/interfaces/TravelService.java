package com.example.block16springcloud.travel.application.interfaces;

import com.example.block16springcloud.travel.domain.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TravelService {

    Travel createTravel(Travel travel);
    Travel readTravel(Integer id);
    Integer readTravelCount(Integer id);
    List<Travel> readAllTravel();
    String verify(Integer id);
    Travel updateTravel(Integer id, Travel travel);
    String updateStatusTravel(Integer id, String status);
    String deleteTravel(Integer id);
}
