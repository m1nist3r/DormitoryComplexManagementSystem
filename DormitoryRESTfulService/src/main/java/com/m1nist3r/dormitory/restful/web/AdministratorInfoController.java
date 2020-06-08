package com.m1nist3r.dormitory.restful.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AdministratorInfoController {

    @GetMapping("/me")
    public ResponseEntity<Map<Object, Object>> currentUser(@AuthenticationPrincipal UserDetails userDetails) {
        Map<Object, Object> model = new HashMap<>();
        model.put("idNumber", userDetails.getUsername());
        model.put("roles", userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toList())
        );
        return ok(model);
    }
}
