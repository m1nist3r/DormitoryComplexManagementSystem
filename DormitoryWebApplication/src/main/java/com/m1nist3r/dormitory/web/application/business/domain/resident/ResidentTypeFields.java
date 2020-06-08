package com.m1nist3r.dormitory.web.application.business.domain.resident;

import java.util.List;

public class ResidentTypeFields {
    private long id;
    private String fieldName;
    private ResidentType residentType;
    private List<ResidentTypeValuesFields> residentTypeValuesFields;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ResidentType getResidentType() {
        return residentType;
    }

    public void setResidentType(ResidentType residentType) {
        this.residentType = residentType;
    }

    public List<ResidentTypeValuesFields> getResidentTypeValuesFields() {
        return residentTypeValuesFields;
    }

    public void setResidentTypeValuesFields(List<ResidentTypeValuesFields> residentTypeValuesFields) {
        this.residentTypeValuesFields = residentTypeValuesFields;
    }

    @Override
    public String toString() {
        return fieldName.replace("_", " ");
    }
}
