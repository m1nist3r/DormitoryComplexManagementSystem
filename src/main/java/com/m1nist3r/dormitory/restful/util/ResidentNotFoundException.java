package com.m1nist3r.dormitory.restful.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResidentNotFoundException extends RuntimeException {

    public ResidentNotFoundException(Long id) {
        super("Resident: " + id + " not found.");
    }
}
