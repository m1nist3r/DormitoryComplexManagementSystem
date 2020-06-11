package com.m1nist3r.dormitory.restful.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(Long id) {
        super("Room: " + id + " not found.");
    }
}
