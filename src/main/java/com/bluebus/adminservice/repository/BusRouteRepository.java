package com.bluebus.adminservice.repository;

import com.bluebus.adminservice.model.Busroute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteRepository extends JpaRepository<Busroute, String> {
}