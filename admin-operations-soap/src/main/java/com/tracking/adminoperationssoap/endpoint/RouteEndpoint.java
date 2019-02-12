package com.tracking.adminoperationssoap.endpoint;

import com.tracking.adminoperationssoap.api.RouteDTOService;
import com.tracking.adminoperationssoap.trackingservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Robi on 1/3/2019.
 */

@Endpoint
public class RouteEndpoint {

    @Autowired
    private RouteDTOService routeDTOService;

    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "addRouteRequest")
    @ResponsePayload
    public AddRouteResponse addRouteResponse(@RequestPayload AddRouteRequest request){
        RouteDTO routeDTOToSave = request.getRoute();
        String responseMessageText = routeDTOService.addRouteDTO(routeDTOToSave);
        AddRouteResponse response = new AddRouteResponse();
        ResponseMessage responseMessage = PackageEndpoint.createResponseMessage(responseMessageText);

        response.setMessage(responseMessage);
        return response;
    }

}
