package com.tracking.adminoperationssoap.api;

import com.tracking.adminoperationssoap.dao.Route;
import com.tracking.adminoperationssoap.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Robi on 1/2/2019.
 */

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public String addRoute(Route routeToSave) {
        String message = "OK";
        try {
            routeRepository.save(routeToSave);
        } catch(Exception e) {
            message = e.getMessage();
        }
        return message;
    }
}
