package com.tracking.adminoperationssoap.endpoint;

import com.tracking.adminoperationssoap.api.PackageDTOService;
import com.tracking.adminoperationssoap.trackingservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;

/**
 * Created by Robi on 12/30/2018.
 */

@Endpoint
public class PackageEndpoint {

    @Autowired
    private PackageDTOService packageDTOService;

    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "getPackageRequest")
    @ResponsePayload
    public GetPackageResponse getPackageResponse(@RequestPayload GetPackageRequest request){
        PackageDTO responsePackageDTO = packageDTOService.getPackage(request.getAwb());
        GetPackageResponse response = new GetPackageResponse();
        response.setPackage(responsePackageDTO);
        return response;
    }

    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "getAllPackagesRequest")
    @ResponsePayload
    public GetAllPackagesResponse getAllPackagesResponse(@RequestPayload GetAllPackagesRequest request){
        ArrayList<PackageDTO> responsePackagesDTO = packageDTOService.getAllPackages();
        GetAllPackagesResponse response = new GetAllPackagesResponse();
        for (PackageDTO responsePackageDTO : responsePackagesDTO) {
            response.getPackage().add(responsePackageDTO);
        }
        return response;
    }

    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "addPackageRequest")
    @ResponsePayload
    public AddPackageResponse addPackageResponse(@RequestPayload AddPackageRequest request){
        PackageDTO packageDTOToSave = request.getPackage();
        String responseMessageText = packageDTOService.addPackageDTO(packageDTOToSave);
        AddPackageResponse response = new AddPackageResponse();
        ResponseMessage responseMessage = createResponseMessage(responseMessageText);

        response.setMessage(responseMessage);
        return response;
    }

    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "registerPackageRequest")
    @ResponsePayload
    public RegisterPackageResponse registerPackageResponse(@RequestPayload RegisterPackageRequest request){
        int awb = request.getAwb();
        String responseMessageText = packageDTOService.registerPackageDTO(awb);
        RegisterPackageResponse response = new RegisterPackageResponse();
        ResponseMessage responseMessage = createResponseMessage(responseMessageText);

        response.setMessage(responseMessage);
        return response;
    }

    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "removePackageRequest")
    @ResponsePayload
    public RemovePackageResponse removePackageResponse(@RequestPayload RemovePackageRequest request){
        int awb = request.getAwb();
        String responseMessageText = packageDTOService.removePackageDTO(awb);
        RemovePackageResponse response = new RemovePackageResponse();
        ResponseMessage responseMessage = createResponseMessage(responseMessageText);

        response.setMessage(responseMessage);
        return response;
    }

    protected static ResponseMessage createResponseMessage(String responseMessageText){
        ResponseMessage responseMessage = new ResponseMessage();
        if(responseMessageText.equals("OK")){
            responseMessage.setStatus("OK");
            responseMessage.setMessage(responseMessageText);
        } else {
            responseMessage.setStatus("ERROR");
            responseMessage.setMessage(responseMessageText);
        }
        return responseMessage;
    }
}
