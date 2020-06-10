package com.m1nist3r.dormitory.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentModel;
import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentType;
import com.m1nist3r.dormitory.restful.business.domain.room.Room;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class RestApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    static String token;
    @Test
    public void settingUpToken() throws Exception {
        String username = "dodik";
        String password = "dodik";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.substring(16, response.length() - 4);
        token = response;
    }


    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/residents")).andExpect(status().isUnauthorized());
    }

    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {
        String username = "dodik";
        String password = "dodik";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

        mvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void nonexistentUserCannotGetToken() throws Exception {
        String username = "nondodik";
        String password = "nondodik";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

        mvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void whenGetRequestToGetAllResident_thenCorrectResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/residents")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }


    public void whenPostRequestToCreateResidentAndValidResident_thenCorrectResponse() throws Exception {
        ResidentModel residentModel = ResidentModel.builder()
                .firstName("Test First Name")
                .lastName("Test Last Name")
                .idNumber("8800553535")
                .sex("F")
                .birthDate(LocalDate.of(1996, 4, 29))
                .mothersName("Test Mother Name")
                .fathersName("Test Father Name")
                .email("andriztan1@gmail.com")
                .country("Ukraine")
                .address("Test Address Ukraine")
                .phoneNumber("+48 333 444 999")
                .accommodationDate(LocalDate.of(2019, 10, 1))
                .evictionDate(LocalDate.of(2020, 7, 1))
                .isBlocked(false)
                .residentType(ResidentType.builder().id(1).build())
                .room(Room.builder().id(1).build())
                .postalCode("12345-412")
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/api/residents").contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(residentModel))
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isCreated());
    }
}
