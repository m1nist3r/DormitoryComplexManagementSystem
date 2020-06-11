package com.m1nist3r.dormitory.restful.web;

import com.m1nist3r.dormitory.restful.security.auth.AuthenticationRequest;
import com.m1nist3r.dormitory.restful.security.auth.administrator.IAdministratorRepository;
import com.m1nist3r.dormitory.restful.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    final AuthenticationManager authenticationManager;

    final JwtTokenProvider jwtTokenProvider;

    final IAdministratorRepository admins;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider, IAdministratorRepository admins) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.admins = admins;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthenticationRequest authenticationRequest) {
        String idNumber = authenticationRequest.getUsername();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(idNumber, authenticationRequest.getPassword()));
        List<String> roles = new ArrayList<>();
        roles.add(this.admins.findByIdNumber(idNumber).orElseThrow(() ->
                new UsernameNotFoundException("Username " + idNumber + "not found")).getAuthGroup().getRole());
        String token = jwtTokenProvider.createToken(idNumber, roles);

        Map<Object, Object> model = new HashMap<>();
      //  model.put("idNumber", idNumber);
        model.put("token", token);
        return ResponseEntity.ok(model);
    }
}
