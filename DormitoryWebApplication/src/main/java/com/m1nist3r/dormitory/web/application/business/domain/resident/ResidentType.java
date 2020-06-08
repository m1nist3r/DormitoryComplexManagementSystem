package com.m1nist3r.dormitory.web.application.business.domain.resident;

import java.util.List;
public class ResidentType {
    private long id;
    private String type;
    private List<Resident> residents;
    private List<ResidentTypeFields> residentTypeFields;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public List<ResidentTypeFields> getResidentTypeFields() {
        return residentTypeFields;
    }

    public void setResidentTypeFields(List<ResidentTypeFields> residentTypeFields) {
        this.residentTypeFields = residentTypeFields;
    }
}
