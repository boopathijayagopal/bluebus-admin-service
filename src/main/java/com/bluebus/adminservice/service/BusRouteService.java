package com.bluebus.adminservice.service;

import com.bluebus.adminservice.entity.BusRoute;
import com.bluebus.adminservice.repo.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusRouteService {

    @Autowired
    private final BusRouteRepository busrouteRepository;
    public BusRouteService(BusRouteRepository busrouteRepository) {
        this.busrouteRepository = busrouteRepository;
    }
    public void createRoute(BusRoute busroute) {
        busrouteRepository.save(busroute);
    }

    public Optional<BusRoute> fetchRoute(String busNumber) {
        return Optional.ofNullable(busrouteRepository.findById(busNumber)
                .orElseThrow(() -> new RuntimeException("Busroute not found for bus number: " + busNumber)));
    }

    public void updateRoute(BusRoute busroute) {
        busrouteRepository.save(busroute);
    }

    public void deleteRoute(String busNumber) {
        busrouteRepository.deleteById(busNumber);
    }
}
