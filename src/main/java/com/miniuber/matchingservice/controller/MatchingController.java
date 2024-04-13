package com.miniuber.matchingservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MatchingController {

    @PostMapping
    ResponseEntity<?> driverMatch() {
        return null;
    }

    @PostMapping
    ResponseEntity<?> passengerMatch() {
        return null;
    }

}
