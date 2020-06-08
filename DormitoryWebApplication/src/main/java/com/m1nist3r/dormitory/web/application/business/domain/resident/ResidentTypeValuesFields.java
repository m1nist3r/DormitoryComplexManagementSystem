package com.m1nist3r.dormitory.web.application.business.domain.resident;

import java.util.List;

public class ResidentTypeValuesFields {
    private long id;
    private String value;
    private List<ResidentTypeFields> residentTypeFields;
    private Resident resident;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ResidentTypeFields> getResidentTypeFields() {
        return residentTypeFields;
    }

    public void setResidentTypeFields(List<ResidentTypeFields> residentTypeFields) {
        this.residentTypeFields = residentTypeFields;
    }
}
