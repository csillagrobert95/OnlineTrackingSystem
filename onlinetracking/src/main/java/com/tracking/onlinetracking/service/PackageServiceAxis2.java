package com.tracking.onlinetracking.service;

import com.tracking.onlinetracking.persistance.User;
import com.tracking.onlinetracking.soapclient.PackageClientAxis2;
import org.apache.axis2.AxisFault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tempuri.*;
import org.tempuri.Package;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Robi on 1/13/2019.
 */
@Service
public class PackageServiceAxis2 {
    PackageClientAxis2 packageClientAxis2;

    {
        try {
            packageClientAxis2 = new PackageClientAxis2();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    public List<Route> getRoutesByAwb(int awb){
        GetRoutesByAwbResponseDocument getRoutesByAwbResponseDocument = packageClientAxis2.getRoutesByAwb(awb);
        GetRoutesByAwbResponseDocument.GetRoutesByAwbResponse getRoutesByAwbResp = getRoutesByAwbResponseDocument.getGetRoutesByAwbResponse();
        ArrayOfRoute arrayOfRoute = getRoutesByAwbResp.getGetRoutesByAwbResult();
        Route[] routeArray = arrayOfRoute.getRouteArray();
        List<Route> routeList = Arrays.asList(routeArray);

        return routeList;
    }

    public List<Package> getPackagesByUserId(int userId){
        GetPackagesByUserIdResponseDocument getPackagesByUserIdResponseDocument = packageClientAxis2.getPackagesByUserId(userId);
        GetPackagesByUserIdResponseDocument.GetPackagesByUserIdResponse getPackagesByUserIdResponse = getPackagesByUserIdResponseDocument.getGetPackagesByUserIdResponse();
        ArrayOfPackage arrayOfPackage = getPackagesByUserIdResponse.getGetPackagesByUserIdResult();
        Package[] packageArray = arrayOfPackage.getPackageArray();
        List<Package> packageList = Arrays.asList(packageArray);

        return packageList;
    }

    public List<Package> getPackagesByUserIdAwb(int userId, int awb){
        GetPackagesByUserIdAwbResponseDocument getPackagesByUserIdAwbResponseDocument = packageClientAxis2.getPackagesByUserIdAwb(userId, awb);
        GetPackagesByUserIdAwbResponseDocument.GetPackagesByUserIdAwbResponse getPackagesByUserIdAwbResponse = getPackagesByUserIdAwbResponseDocument.getGetPackagesByUserIdAwbResponse();
        ArrayOfPackage arrayOfPackage = getPackagesByUserIdAwbResponse.getGetPackagesByUserIdAwbResult();
        Package[] packageArray = arrayOfPackage.getPackageArray();
        List<Package> packageList = Arrays.asList(packageArray);

        return packageList;
    }

    public String registerUser(User user){
        user.setPassword(encoder().encode(user.getPassword()));

        RegisterUserResponseDocument registerUserResponseDocument = packageClientAxis2.registerUser(user);
        RegisterUserResponseDocument.RegisterUserResponse registerUserResponse = registerUserResponseDocument.getRegisterUserResponse();
        return registerUserResponse.getRegisterUserResult();
    }



    private static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
}
