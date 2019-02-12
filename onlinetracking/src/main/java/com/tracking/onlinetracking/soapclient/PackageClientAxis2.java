package com.tracking.onlinetracking.soapclient;

import com.tracking.onlinetracking.persistance.User;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.tempuri.*;
import packagesclient.TrackingServiceClientStub;
import org.apache.axis2.AxisFault;

import java.rmi.RemoteException;

/**
 * Created by Robi on 1/13/2019.
 */
public class PackageClientAxis2 {

    TrackingServiceClientStub serviceStub;
    public PackageClientAxis2() throws AxisFault {
        serviceStub = new TrackingServiceClientStub();
        Options options =serviceStub._getServiceClient().getOptions();
        options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true");
        options.setProperty(HTTPConstants.CHUNKED, "false");
        options.setManageSession(true);
    }

    public GetRoutesByAwbResponseDocument getRoutesByAwb(int awb){
        GetRoutesByAwbDocument.GetRoutesByAwb getRoutesByAwb = GetRoutesByAwbDocument.GetRoutesByAwb.Factory.newInstance();
        getRoutesByAwb.setAwb(awb);

        GetRoutesByAwbDocument getRoutesByAwbDocument = GetRoutesByAwbDocument.Factory.newInstance();
        getRoutesByAwbDocument.setGetRoutesByAwb(getRoutesByAwb);

        GetRoutesByAwbResponseDocument getRoutesByAwbResponse = null;

        try {
            getRoutesByAwbResponse = serviceStub.getRoutesByAwb(getRoutesByAwbDocument);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return getRoutesByAwbResponse;
    }

    public RegisterUserResponseDocument registerUser(User user){
        RegisterUserDocument.RegisterUser userToRegister = RegisterUserDocument.RegisterUser.Factory.newInstance();
        userToRegister.setFirstName(user.getFirstName());
        userToRegister.setLastName(user.getLastName());
        userToRegister.setUsername(user.getUsername());
        userToRegister.setEmail(user.getEmail());
        userToRegister.setPassword(user.getPassword());

        RegisterUserDocument registerUserDocument = RegisterUserDocument.Factory.newInstance();
        registerUserDocument.setRegisterUser(userToRegister);

        RegisterUserResponseDocument registerUserResponse = null;
        try{
            registerUserResponse = serviceStub.registerUser(registerUserDocument);
        } catch(RemoteException e){
            e.printStackTrace();
        }

        return registerUserResponse;
    }

    public GetPackagesByUserIdResponseDocument getPackagesByUserId (int userId){
        GetPackagesByUserIdDocument.GetPackagesByUserId getPackagesByUserId = GetPackagesByUserIdDocument.GetPackagesByUserId.Factory.newInstance();
        getPackagesByUserId.setUserId(userId);

        GetPackagesByUserIdDocument getPackagesByUserIdDocument = GetPackagesByUserIdDocument.Factory.newInstance();
        getPackagesByUserIdDocument.setGetPackagesByUserId(getPackagesByUserId);

        GetPackagesByUserIdResponseDocument getPackagesByUserIdResponse = null;
        try{
            getPackagesByUserIdResponse = serviceStub.getPackagesByUserId(getPackagesByUserIdDocument);
        } catch(RemoteException e){
            e.printStackTrace();
        }

        return getPackagesByUserIdResponse;
    }

    public GetPackagesByUserIdAwbResponseDocument getPackagesByUserIdAwb (int userId, int awb){
        GetPackagesByUserIdAwbDocument.GetPackagesByUserIdAwb getPackagesByUserIdAwb = GetPackagesByUserIdAwbDocument.GetPackagesByUserIdAwb.Factory.newInstance();
        getPackagesByUserIdAwb.setAwb(awb);
        getPackagesByUserIdAwb.setUserId(userId);

        GetPackagesByUserIdAwbDocument getPackagesByUserIdAwbDocument = GetPackagesByUserIdAwbDocument.Factory.newInstance();
        getPackagesByUserIdAwbDocument.setGetPackagesByUserIdAwb(getPackagesByUserIdAwb);

        GetPackagesByUserIdAwbResponseDocument getPackagesByUserIdAwbResponseDocument = null;
        try{
            getPackagesByUserIdAwbResponseDocument = serviceStub.getPackagesByUserIdAwb(getPackagesByUserIdAwbDocument);
        } catch(RemoteException e){
            e.printStackTrace();
        }

        return getPackagesByUserIdAwbResponseDocument;
    }
}
