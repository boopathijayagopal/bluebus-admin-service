package com.bluebus.adminservice.controller;

import com.bluebus.adminservice.entity.BusRoute;
import com.bluebus.adminservice.service.BusRouteService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AdminServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceController.class);

    @Autowired
    private final BusRouteService busRouteService;
    public AdminServiceController(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @PostMapping("addRoute")
    public ResponseEntity<String> addRoute(@RequestBody @NonNull BusRoute busroute, @RequestHeader("Authorization") String token) {
        if (!busRouteService.validateToken(token)) {
            LOGGER.info("Unauthorized access attempt with token: {}", token);
            return ResponseEntity.status(401).body("Unauthorized: Missing or invalid token");
        }
        LOGGER.info("Adding new bus route for bus number: {}", busroute.getBusnumber());
        busRouteService.createRoute(busroute);
        return ResponseEntity.ok("New Busroute added for bus number: " + busroute.getBusnumber());
    }

    @GetMapping("fetchRoute/{busNumber}")
    public ResponseEntity<?> fetchRoute(@PathVariable String busNumber, @RequestHeader("Authorization") String token) {
        if (!busRouteService.validateToken(token)) {
            LOGGER.info("Unauthorized access attempt with token: {}", token);
            return ResponseEntity.status(401).body("Unauthorized: Missing or invalid token");
        }
        LOGGER.info("Fetching bus route for bus number: {}", busNumber);
        if (busNumber == null || busNumber.isEmpty()) {
            return ResponseEntity.badRequest().body(Optional.empty());
        }
        return ResponseEntity.ok(busRouteService.fetchRoute(busNumber));
    }

    @PutMapping("editRoute")
    public ResponseEntity<String> editRoute(@RequestBody BusRoute busroute, @RequestHeader("Authorization") String token) {
        if (!busRouteService.validateToken(token)) {
            LOGGER.info("Unauthorized access attempt with token: {}", token);
            return ResponseEntity.status(401).body("Unauthorized: Missing or invalid token");
        }
        LOGGER.info("Editing bus route for bus number: {}", busroute.getBusnumber());
        busRouteService.updateRoute(busroute);
        LOGGER.info("Edited Busroute for bus number: {}", busroute.getBusnumber());
        return ResponseEntity.ok("Edited Busroute for bus number: " + busroute.getBusnumber());
    }

    @DeleteMapping("deleteRoute/{busNumber}")
    public ResponseEntity<String> deleteRoute(@PathVariable String busNumber, @RequestHeader("Authorization") String token) {
        if (!busRouteService.validateToken(token)) {
            LOGGER.info("Unauthorized access attempt with token: {}", token);
            return ResponseEntity.status(401).body("Unauthorized: Missing or invalid token");
        }
        LOGGER.info("Deleting bus route for bus number: {}", busNumber);
        busRouteService.deleteRoute(busNumber);
        return ResponseEntity.ok("Deleted Busroute for bus number: " + busNumber);
    }
}