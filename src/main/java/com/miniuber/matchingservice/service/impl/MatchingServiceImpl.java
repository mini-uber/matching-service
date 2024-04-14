package com.miniuber.matchingservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniuber.matchingservice.service.MatchingService;
import com.miniuber.matchingservice.util.Location;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchingServiceImpl implements MatchingService {

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public MatchingServiceImpl(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Location> driverMatch(Location driverLocation) {

        String endpointUrl = "ENDPOINT_URL_HERE";
        List<Location> passengerLocations = fetchLocationsFromEndpoint(endpointUrl);

        List<Location> sortedLocations = passengerLocations.stream()
                .sorted(Comparator.comparingDouble(location ->
                        calculateDistance(location, driverLocation)))
                .limit(5)
                .collect(Collectors.toList());

        return sortedLocations;

    }

    @Override
    public List<Location> passengerMatch(Location passengerLocation) {

        String endpointUrl = "ENDPOINT_URL_HERE";
        List<Location> driverLocations = fetchLocationsFromEndpoint(endpointUrl);

        List<Location> sortedLocations = driverLocations.stream()
                .sorted(Comparator.comparingDouble(location ->
                        calculateDistance(location, passengerLocation)))
                .limit(5)
                .collect(Collectors.toList());

        return sortedLocations;

    }

    private List<Location> fetchLocationsFromEndpoint(String endpointUrl) {

        String responseJson = restTemplate.getForObject(endpointUrl, String.class);

        try {
            List<Location> locations = objectMapper.readValue(responseJson,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Location.class));
            return locations;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private double calculateDistance(Location location1, Location location2) {

        return Math.sqrt(Math.pow(location1.getLatitude() - location2.getLatitude(), 2) +
                Math.pow(location1.getLongitude() - location2.getLongitude(), 2));

    }

}
