package com.jetbrainslab.khayrullin.entity;

import com.jetbrainslab.khayrullin.enums.RequestStatus;
import com.jetbrainslab.khayrullin.enums.ServiceType;

import java.sql.Timestamp;

public class Request {
    private int id;
    private int needyId;
    private int volonteerId;
    private String address;
    private Long latitude;
    private Long longitude;
    private Timestamp createdAt;
    private ServiceType serviceType;
    private RequestStatus requestStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNeedyId() {
        return needyId;
    }

    public void setNeedyId(int needyId) {
        this.needyId = needyId;
    }

    public int getVolonteerId() {
        return volonteerId;
    }

    public void setVolonteerId(int volonteerId) {
        this.volonteerId = volonteerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getServiceTypeString() {
        return serviceType.toString();
    }

    public String getRequestStatusString() {
        return requestStatus.toString();
    }
}
