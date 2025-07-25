package com.bluebus.adminservice.repo;

import com.bluebus.adminservice.entity.Busroute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteRepository extends JpaRepository<Busroute, String> {
}