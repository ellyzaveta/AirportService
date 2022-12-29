package com.airportService.backend.data;

import com.airportService.backend.models.Aircraft;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AircraftFactory {
    private static final Random random = new Random();

    private static final List<Double> fuel = Stream.of(4.5, 5.5, 6.5, 7.5, 8.5, 10.5)
            .collect(Collectors.toList());

    private static final Map<String, Integer> modelAndTotalNumOfSeats = Stream.of(
                    new AbstractMap.SimpleEntry<>("b737", 124),
                    new AbstractMap.SimpleEntry<>("a321", 142),
                    new AbstractMap.SimpleEntry<>("a319", 94),
                    new AbstractMap.SimpleEntry<>("a320", 106))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static Aircraft getRandAircraft() {
        List<String> models = new ArrayList<>(modelAndTotalNumOfSeats.keySet());
        String model = models.get(random.nextInt(models.size()));
        Integer numOfPlaces = modelAndTotalNumOfSeats.get(model);
        Double fuelPerHour = fuel.get(random.nextInt(fuel.size()));
        Aircraft aircraft = new Aircraft();
        aircraft.setFuelPerHour(fuelPerHour);
        aircraft.setModel(model);
        aircraft.setTotalNumOfPlaces(numOfPlaces);

        return aircraft;
    }
}
