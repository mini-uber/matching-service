package com.miniuber.matchingservice.service;

import com.miniuber.matchingservice.util.Location;

import java.util.List;

public interface MatchingService {

    List<Location> driverMatch(Location driverLocation);
    List<Location> passengerMatch(Location passengerLocation);

}
