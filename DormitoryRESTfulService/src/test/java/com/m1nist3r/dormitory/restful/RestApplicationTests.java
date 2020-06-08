package com.m1nist3r.dormitory.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m1nist3r.dormitory.restful.business.domain.resident.Resident;
import com.m1nist3r.dormitory.restful.business.domain.resident.ResidentType;
import com.m1nist3r.dormitory.restful.business.service.resident.IResidentService;
import com.m1nist3r.dormitory.restful.util.ResidentNotFoundException;
import com.m1nist3r.dormitory.restful.web.ResidentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static java.nio.charset.StandardCharsets.*;
import static org.springframework.http.MediaType.ALL;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@SpringBootTest
@AutoConfigureMockMvc
class RestApplicationTests {

    @Autowired
    private IResidentService residentService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
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

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.substring(16, response.length() - 4);
        String token = response;
        System.out.println(token);
        mvc.perform(MockMvcRequestBuilders.get("/residents")
                .header("Authorization", "Bearer " + token))
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
                .andExpect(status().isUnauthorized()).andReturn();
    }

    @Test
    public void whenPostRequestToCreateResidentAndValidResident_thenCorrectResponse() throws Exception {
        String username = "dodik";
        String password = "dodik";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.substring(16, response.length() - 4);
        String token = response;
        System.out.println(token);
        mvc.perform(MockMvcRequestBuilders.get("/api/residents")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());

        Resident resident = residentService.findOneResident(1L).orElseThrow(() -> new ResidentNotFoundException(1L));
        resident.setId(2L);
        resident.setFirstName("");
        mvc.perform(MockMvcRequestBuilders.post("/api/residents").contentType(ALL)
                .content(objectMapper.writeValueAsString(resident))
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isCreated());
    }
}
