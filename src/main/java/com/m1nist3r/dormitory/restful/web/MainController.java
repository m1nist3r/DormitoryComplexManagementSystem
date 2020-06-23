package com.m1nist3r.dormitory.restful.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @GetMapping
    public String getIndex() {
        return "redirect:/swagger-ui.html";
    }
}
