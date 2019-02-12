package com.tracking.adminoperationssoap.api;

import com.tracking.adminoperationssoap.dao.Package;
import com.tracking.adminoperationssoap.trackingservice.PackageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Robi on 1/1/2019.
 */
@Service
public class PackageDTOService {
    @Autowired
    private PackageService packageService;

    public PackageDTO getPackage(int awb) {
        Package responsePackage = packageService.getPackage(awb);
        PackageDTO responsePackageDTO = convertPackageToDTO(responsePackage);

        return responsePackageDTO;
    }

    public ArrayList<PackageDTO> getAllPackages() {
        List<Package> responsePackages = packageService.getAllPackages();
        ArrayList<PackageDTO> responsePackagesDTO = new ArrayList<>();

        for (Package responsePackage: responsePackages) {
            PackageDTO responsePackageDTO = convertPackageToDTO(responsePackage);
            responsePackagesDTO.add(responsePackageDTO);
        }

        return responsePackagesDTO;
    }

    public String addPackageDTO(PackageDTO packageDTO){
        Package packageToSave = convertDTOToPackage(packageDTO);
        String message = packageService.addPackage(packageToSave);
        return message;
    }

    public String registerPackageDTO(int awb){
        String message = packageService.registerPackage(awb);
        return message;
    }

    public String removePackageDTO(int awb){
        String message = packageService.removePackage(awb);
        return message;
    }

    public static Package convertDTOToPackage(PackageDTO packageDTO){
        Package convertedPackage = new Package();

        convertedPackage.setAwb(packageDTO.getAwb());
        convertedPackage.setSenderId(packageDTO.getSenderId());
        convertedPackage.setReceiverId(packageDTO.getReceiverId());
        convertedPackage.setPackageName(packageDTO.getPackageName());
        convertedPackage.setPackageDescription(packageDTO.getPackageDescription());
        convertedPackage.setSenderCity(packageDTO.getSenderCity());
        convertedPackage.setDestinationCity(packageDTO.getDestinationCity());
        convertedPackage.setTracked(packageDTO.getTracked());

        return convertedPackage;
    }

    public static PackageDTO convertPackageToDTO(Package packageToConvert){
        PackageDTO convertedPackageDTO = new PackageDTO();

        convertedPackageDTO.setAwb(packageToConvert.getAwb());
        convertedPackageDTO.setSenderId(packageToConvert.getSenderId());
        convertedPackageDTO.setReceiverId(packageToConvert.getReceiverId());
        convertedPackageDTO.setPackageName(packageToConvert.getPackageName());
        convertedPackageDTO.setPackageDescription(packageToConvert.getPackageDescription());
        convertedPackageDTO.setSenderCity(packageToConvert.getSenderCity());
        convertedPackageDTO.setDestinationCity(packageToConvert.getDestinationCity());
        convertedPackageDTO.setTracked(packageToConvert.getTracked());

        return convertedPackageDTO;
    }
}
