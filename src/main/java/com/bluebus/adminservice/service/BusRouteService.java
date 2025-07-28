package com.bluebus.adminservice.service;

import com.bluebus.adminservice.entity.BusRoute;
import com.bluebus.adminservice.repo.BusRouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class BusRouteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusRouteService.class);

    @Autowired
    private BusRouteRepository busrouteRepository;

    @Autowired
    private AuthValidationService authValidationService;

    public void createRoute(BusRoute busroute) {
        LOGGER.info("Creating new bus route for bus number: {}", busroute.getBusnumber());
        busroute.setCreationdate(getDateTime());
        busroute.setLastupdateddate(getDateTime());
        busrouteRepository.save(busroute);
        LOGGER.info("New Busroute created for bus number: {}", busroute.getBusnumber());
    }

    public Optional<BusRoute> fetchRoute(String busNumber) {
        LOGGER.info("Fetching bus route for bus number: {}", busNumber);
        return Optional.ofNullable(busrouteRepository.findById(busNumber)
                .orElseThrow(() -> new RuntimeException("Busroute not found for bus number: " + busNumber)));
    }

    public void updateRoute(BusRoute busroute) {
        LOGGER.info("Updating bus route for bus number: {}", busroute.getBusnumber());
        BusRoute existingRoute = fetchRoute(busroute.getBusnumber()).orElseThrow();
        existingRoute.setSource(busroute.getSource());
        existingRoute.setDestination(busroute.getDestination());
        existingRoute.setBusnumber(busroute.getBusnumber());
        existingRoute.setPrice(busroute.getPrice());
        existingRoute.setLastupdateddate(getDateTime());
        busrouteRepository.save(existingRoute);
        LOGGER.info("Edited Busroute for bus number: {}", busroute.getBusnumber());
    }

    public void deleteRoute(String busNumber) {
        LOGGER.info("Deleting bus route for bus number: {}", busNumber);
        busrouteRepository.deleteById(busNumber);
    }

    private String getDateTime() {
        LOGGER.info("Generating current date and time in dd-MM-yyyy HH:mm:ss format");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dateTimeFormatter);
    }

    public boolean validateToken(String token) {
        LOGGER.info("Validating token: {}", token);
        // For simplicity, let's assume a valid token is "valid-token"
        if (token == null || !authValidationService.validateToken(token)) {
            LOGGER.warn("Invalid token provided: {}", token);
            return false;
        }
        LOGGER.info("Token is valid");
        return true;
    }
}
