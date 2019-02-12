package com.tracking.onlinetracking.soapclient;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import packages.wsdl.*;

/**
 * Created by Robi on 1/12/2019.
 */
public class PackageClient extends WebServiceGatewaySupport {
    public GetPackageResponse getPackageByAwb(int awb){
        GetPackageRequest getPackageRequest = new GetPackageRequest();
        getPackageRequest.setAwb(awb);

        return (GetPackageResponse) getWebServiceTemplate().marshalSendAndReceive(getPackageRequest);
    }

    public GetAllPackagesResponse getAllPackages(){
        GetAllPackagesRequest getAllPackagesRequest = new GetAllPackagesRequest();
        return (GetAllPackagesResponse) getWebServiceTemplate().marshalSendAndReceive(getAllPackagesRequest);
    }

    public AddPackageResponse addPackage(PackageDTO packageDTO){
        AddPackageRequest addPackageRequest = new AddPackageRequest();
        addPackageRequest.setPackage(packageDTO);

        return (AddPackageResponse) getWebServiceTemplate().marshalSendAndReceive(addPackageRequest);
    }

    public RemovePackageResponse removePackage(int awb){
        RemovePackageRequest removePackageRequest = new RemovePackageRequest();
        removePackageRequest.setAwb(awb);

        return (RemovePackageResponse) getWebServiceTemplate().marshalSendAndReceive(removePackageRequest);
    }

    public RegisterPackageResponse registerPackage(int awb){
        RegisterPackageRequest registerPackageRequest = new RegisterPackageRequest();
        registerPackageRequest.setAwb(awb);

        return (RegisterPackageResponse) getWebServiceTemplate().marshalSendAndReceive(registerPackageRequest);
    }

    public AddRouteResponse addRoute(RouteDTO routeDTO){
        AddRouteRequest addRouteRequest = new AddRouteRequest();
        addRouteRequest.setRoute(routeDTO);

        return (AddRouteResponse) getWebServiceTemplate().marshalSendAndReceive(addRouteRequest);
    }
}
