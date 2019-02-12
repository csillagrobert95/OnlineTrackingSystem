package com.tracking.adminoperationssoap.api;

import com.tracking.adminoperationssoap.dao.Package;
import com.tracking.adminoperationssoap.repository.PackageRepository;
import com.tracking.adminoperationssoap.trackingservice.PackageDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Robi on 12/29/2018.
 */
@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public Package getPackage(int awb) {
        Optional<Package> optionalPackage = packageRepository.findById(awb);
        return optionalPackage.get();
    }

    public List<Package> getAllPackages() {
        List<Package> packageList = packageRepository.findAll();
        return packageList;
    }

    public String addPackage(Package packageToSave) {
        String message = "OK";
        try {
            packageRepository.save(packageToSave);
        } catch(Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    public String registerPackage(int awb) {
        String message = "OK";
        try {
            Optional<Package> optionalPackage = packageRepository.findById(awb);
            Package packageToTrack = optionalPackage.get();
            packageToTrack.setTracked(1);
            packageRepository.save(packageToTrack);
        } catch(Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    public String removePackage(int awb) {
        String message = "OK";
        try {
            packageRepository.deleteById(awb);
        } catch(Exception e) {
            message = e.getMessage();
        }
        return message;
    }
}
