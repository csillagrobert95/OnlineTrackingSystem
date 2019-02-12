package com.tracking.adminoperationssoap.api;

/**
 * Created by Robi on 1/3/2019.
 */

import com.tracking.adminoperationssoap.dao.Route;
import com.tracking.adminoperationssoap.trackingservice.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteDTOService {
    @Autowired
    private RouteService routeService;

    public String addRouteDTO(RouteDTO routeDTO){
        Route routeToSave = convertDTOToRoute(routeDTO);
        String message = routeService.addRoute(routeToSave);
        return message;
    }

    public static Route convertDTOToRoute(RouteDTO routeDTO){
        Route convertedRoute = new Route();

        convertedRoute.setAwb(routeDTO.getAwb());
        convertedRoute.setRouteNr(routeDTO.getRouteId());
        convertedRoute.setCity(routeDTO.getCity());
        convertedRoute.setReceiveTime(routeDTO.getReceiveTime());


        return convertedRoute;
    }
}
