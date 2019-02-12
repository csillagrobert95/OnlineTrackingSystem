package com.tracking.adminoperationssoap.repository;

import com.tracking.adminoperationssoap.dao.Route;
import com.tracking.adminoperationssoap.dao.RoutePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Robi on 12/29/2018.
 */

@Repository
public interface RouteRepository extends JpaRepository<Route, RoutePK> {
}
