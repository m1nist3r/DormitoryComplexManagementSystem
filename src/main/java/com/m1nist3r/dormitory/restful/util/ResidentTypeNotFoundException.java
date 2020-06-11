package com.m1nist3r.dormitory.restful.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResidentTypeNotFoundException extends RuntimeException {

    public ResidentTypeNotFoundException(Long id) {
        super("Resident type: " + id + " not found.");
    }
}
