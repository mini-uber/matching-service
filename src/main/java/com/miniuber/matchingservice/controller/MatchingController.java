package com.miniuber.matchingservice.controller;

import com.miniuber.matchingservice.service.MatchingService;
import com.miniuber.matchingservice.util.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/matcher")
@RequiredArgsConstructor
public class MatchingController {

    private final MatchingService matchingService;

    @PostMapping("/driver")
    ResponseEntity<List<Location>> driverMatch(@RequestBody Location driverLocation) {

        List<Location> passengerLocations = matchingService.driverMatch(driverLocation);

        return ResponseEntity.ok(passengerLocations);

    }

    @PostMapping("/passenger")
    ResponseEntity<List<Location>> passengerMatch(@RequestBody Location passengerLocation) {

        List<Location> driverLocations = matchingService.passengerMatch(passengerLocation);

        return ResponseEntity.ok(driverLocations);

    }

}
