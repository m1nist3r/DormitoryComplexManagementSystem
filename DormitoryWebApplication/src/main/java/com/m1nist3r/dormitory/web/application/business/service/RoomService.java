package com.m1nist3r.dormitory.web.application.business.service;

import com.m1nist3r.dormitory.web.application.business.domain.room.Room;
import com.m1nist3r.dormitory.web.application.business.domain.room.RoomModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RoomService {
    private static final String ROOMS = "/rooms";
    private static final String SLASH = "/";

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${dormitory.service.url}")
    private String dormitoryRestService;

    public List<Room> findPaginatedAllRooms(String page, String size, String searched) {
        String url = dormitoryRestService + ROOMS + "?page={page}&size={size}&searched={searched}";
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<List<Room>>() {
                }, page, size, searched).getBody();
    }

    public List<Room> findAllFreeRooms() {
        String url = dormitoryRestService + ROOMS + SLASH + "free";
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<List<Room>>() {
                }).getBody();
    }

    public Room getRoomDetails(long id) {
        String url = dormitoryRestService + ROOMS + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, Room.class).getBody();
    }

    public Room updateRoom(long id, RoomModel roomModel) {
        System.out.println(roomModel);
        String url = dormitoryRestService + ROOMS + SLASH + id;
        HttpEntity<RoomModel> request = new HttpEntity<>(roomModel, null);
        return this.restTemplate.exchange(url, HttpMethod.PUT, request, Room.class).getBody();
    }
}
