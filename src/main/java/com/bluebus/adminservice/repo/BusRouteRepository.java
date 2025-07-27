package com.bluebus.adminservice.repo;

import com.bluebus.adminservice.entity.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteRepository extends JpaRepository<BusRoute, String> {
}