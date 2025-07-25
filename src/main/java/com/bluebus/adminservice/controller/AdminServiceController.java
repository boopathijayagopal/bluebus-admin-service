package com.bluebus.adminservice.controller;

import com.bluebus.adminservice.entity.Busroute;
import com.bluebus.adminservice.repo.BusRouteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AdminServiceController {
    private final BusRouteRepository busrouteRepository;

    public AdminServiceController(BusRouteRepository busrouteRepository) {
        this.busrouteRepository = busrouteRepository;
    }

    @PostMapping("addRoute")
    public ResponseEntity<String> addRoute(@RequestBody Busroute busroute) {
         busrouteRepository.save(busroute);
        return ResponseEntity.ok("New Busroute added for bus number: " + busroute.getBusnumber());
    }

    @GetMapping("fetchRoute/{busNumber}")
    public ResponseEntity<Optional<Busroute>> fetchRoute(@PathVariable String busNumber) {
        return ResponseEntity.ok(busrouteRepository.findById(busNumber));
    }

    @PutMapping("editRoute")
    public ResponseEntity<String> editRoute(@RequestBody Busroute busroute) {
          busrouteRepository.save(busroute);
        return ResponseEntity.ok("Edited Busroute for bus number: " + busroute.getBusnumber());
    }

    @DeleteMapping("deleteRoute/{busNumber}")
    public ResponseEntity<String> deleteRoute(@PathVariable String busNumber) {
        busrouteRepository.deleteById(busNumber);
        return ResponseEntity.ok("Deleted Busroute for bus number: " + busNumber);
    }

}