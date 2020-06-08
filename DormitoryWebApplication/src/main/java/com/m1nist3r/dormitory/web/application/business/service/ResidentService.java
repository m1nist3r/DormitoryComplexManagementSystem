package com.m1nist3r.dormitory.web.application.business.service;

import com.m1nist3r.dormitory.web.application.business.domain.resident.Resident;
import com.m1nist3r.dormitory.web.application.business.domain.resident.ResidentModel;
import com.m1nist3r.dormitory.web.application.business.domain.resident.ResidentType;
import com.m1nist3r.dormitory.web.application.business.domain.resident.ResidentTypeFields;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ResidentService {
    private static final String RESIDENTS = "/residents";
    private static final String SLASH = "/";

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${dormitory.service.url}")
    private String dormitoryRestService;

    public List<Resident> findPaginatedAllResidents(String page, String size, String searched) {
        String url = dormitoryRestService + RESIDENTS + "?page={page}&size={size}&searched={searched}";
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<List<Resident>>() {
                }, page, size, searched).getBody();
    }

    public List<ResidentTypeFields> getResidentTypeFields(String id) {
        String url = dormitoryRestService + RESIDENTS + "fields" + "?id={id}";
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<List<ResidentTypeFields>>() {
                }, id).getBody();
    }

    public Resident addResident(ResidentModel residentModel) {
        String url = dormitoryRestService + RESIDENTS;
        HttpEntity<ResidentModel> request = new HttpEntity<>(residentModel, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, Resident.class).getBody();
    }

    public List<ResidentType> getResidentTypeList() {
        String url = dormitoryRestService + RESIDENTS + SLASH + "types";
        HttpEntity<ResidentModel> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<List<ResidentType>>() {
        }).getBody();
    }

    public Resident getResidentDetails(long id) {
        String url = dormitoryRestService + RESIDENTS + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, Resident.class).getBody();
    }

    public Resident updateResident(long id, ResidentModel residentModel) {
        System.out.println(residentModel);
        String url = dormitoryRestService + RESIDENTS + SLASH + id;
        HttpEntity<ResidentModel> request = new HttpEntity<>(residentModel, null);
        return this.restTemplate.exchange(url, HttpMethod.PUT, request, Resident.class).getBody();
    }
}
