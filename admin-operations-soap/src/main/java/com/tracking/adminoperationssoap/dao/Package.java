package com.tracking.adminoperationssoap.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Robi on 12/29/2018.
 */
@Entity
@Table(name = "package")
public class Package {
    @Id
    @Column(name = "awb")
    private int awb;
    @Column(name = "sender_id")
    private int senderId;
    @Column(name = "receiver_id")
    private int receiverId;
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "package_description")
    private String packageDescription;
    @Column(name = "sender_city")
    private String senderCity;
    @Column(name = "destination_city")
    private String destinationCity;
    @Column(name = "tracked")
    private int tracked;

    public Package(int awb, int senderId, int receiverId, String packageName, String packageDescription, String senderCity, String destinationCity, int tracked) {
        this.awb = awb;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.packageName = packageName;
        this.packageDescription = packageDescription;
        this.senderCity = senderCity;
        this.destinationCity = destinationCity;
        this.tracked = tracked;
    }

    public Package() {

    }

    public int getAwb() {
        return awb;
    }

    public void setAwb(int awb) {
        this.awb = awb;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getTracked() {
        return tracked;
    }

    public void setTracked(int tracked) {
        this.tracked = tracked;
    }
}
