package com.bluebus.adminservice.controller;

import com.bluebus.adminservice.entity.BusRoute;
import com.bluebus.adminservice.service.BusRouteService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AdminServiceController {

    @Autowired
    private final BusRouteService busRouteService;
    public AdminServiceController(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @PostMapping("addRoute")
    public ResponseEntity<String> addRoute(@RequestBody @NonNull BusRoute busroute) {
        busRouteService.createRoute(busroute);
        return ResponseEntity.ok("New Busroute added for bus number: " + busroute.getBusnumber());
    }

    @GetMapping("fetchRoute/{busNumber}")
    public ResponseEntity<Optional<BusRoute>> fetchRoute(@PathVariable String busNumber) {
        if (busNumber == null || busNumber.isEmpty()) {
            return ResponseEntity.badRequest().body(Optional.empty());
        }
        return ResponseEntity.ok(busRouteService.fetchRoute(busNumber));
    }

    @PutMapping("editRoute")
    public ResponseEntity<String> editRoute(@RequestBody BusRoute busroute) {
        busRouteService.updateRoute(busroute);
        return ResponseEntity.ok("Edited Busroute for bus number: " + busroute.getBusnumber());
    }

    @DeleteMapping("deleteRoute/{busNumber}")
    public ResponseEntity<String> deleteRoute(@PathVariable String busNumber) {
        busRouteService.deleteRoute(busNumber);
        return ResponseEntity.ok("Deleted Busroute for bus number: " + busNumber);
    }

}