package com.tracking.onlinetracking.service;

import com.tracking.onlinetracking.config.SoapClientConfig;
import com.tracking.onlinetracking.soapclient.PackageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.tempuri.Route;
import packages.wsdl.*;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Robi on 1/12/2019.
 */
@Service
public class PackageService {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
    PackageClient client = context.getBean(PackageClient.class);



    public PackageDTO getPackageByAwb(int awb){
        GetPackageResponse response = client.getPackageByAwb(awb);
        return response.getPackage();
    }

    public List<PackageDTO> getAllPackages(){
        GetAllPackagesResponse response = client.getAllPackages();
        return response.getPackage();
    }

    public ResponseMessage addPackage(PackageDTO packageDTO){
        int generatedAwb = ThreadLocalRandom.current().nextInt(1000000000, 1999999999);
        packageDTO.setAwb(generatedAwb);
        packageDTO.setTracked(0);
        AddPackageResponse response = client.addPackage(packageDTO);
        return response.getMessage();
    }

    public ResponseMessage removePackage(int awb){
        RemovePackageResponse response = client.removePackage(awb);
        return response.getMessage();
    }

    public ResponseMessage addRoute(int awb, String city){
        RegisterPackageResponse registerResponse = client.registerPackage(awb);

        PackageServiceAxis2 packageServiceAxis2 = new PackageServiceAxis2();
        List<Route> routeList = packageServiceAxis2.getRoutesByAwb(awb);
        int maxRouteNr = 0;
        for (Route route:routeList) {
            if(route.getRouteNr() > maxRouteNr){
                maxRouteNr = route.getRouteNr();
            }
        }

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setAwb(awb);
        routeDTO.setRouteId(maxRouteNr + 1);
        routeDTO.setCity(city);
        routeDTO.setReceiveTime(currentTimestamp.toString());

        AddRouteResponse response = client.addRoute(routeDTO);

        return response.getMessage();
    }


}
