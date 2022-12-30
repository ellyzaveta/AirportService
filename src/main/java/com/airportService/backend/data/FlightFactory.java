package com.airportService.backend.data;

import com.airportService.backend.models.Aircraft;
import com.airportService.backend.models.Flight;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightFactory {
    private static final Random random = new Random();

    private static final List<Double> price = Stream.of(120.0, 50.0, 300.0, 45.0, 79.5, 45.0, 15.0)
            .collect(Collectors.toList());

    private static final List<String> airports = Stream.of("Kyiv", "Vienna", "Warsaw", "London", "Paris", "Amsterdam", "Berlin", "Barcelona")
            .collect(Collectors.toList());

    private static Date getDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2022, 2023);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return gc.getTime();
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static Date getDateIn2Hours() {
        Date cur = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cur);
        calendar.add(Calendar.HOUR_OF_DAY, random.nextInt(2));
        return calendar.getTime();
    }

    public static Flight getRandFlight() {
        Date departureTime = getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departureTime);
        calendar.add(Calendar.HOUR_OF_DAY, randBetween(1, 4));
        Date arrivalTime;
        do{
            arrivalTime = calendar.getTime();
        }while(arrivalTime == departureTime);

        String depAirport = airports.get(random.nextInt(airports.size()));
        String arrAirport;
        do {
            arrAirport = airports.get(random.nextInt(airports.size()));
        } while (Objects.equals(depAirport, arrAirport));
        Double curPrice = price.get(random.nextInt(price.size()));
        Aircraft aircraft = AircraftFactory.getRandAircraft();
        Flight flight = new Flight();
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setTotalTime(TimeUnit.MILLISECONDS.toHours(arrivalTime.getTime() - departureTime.getTime()));
        flight.setPrice(curPrice);
        flight.setDepAirport(depAirport);
        flight.setArrAirport(arrAirport);
        flight.setAircraft(aircraft);
        flight.setNumOfAvailablePlaces(aircraft.getTotalNumOfPlaces());
        return flight;
    }

    public static Flight getRandFlightIn2Hours() {
        Date departureTime = getDateIn2Hours();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departureTime);
        calendar.add(Calendar.HOUR_OF_DAY, randBetween(1, 4));
        Date arrivalTime = calendar.getTime();
        String depAirport = airports.get(random.nextInt(airports.size()));
        String arrAirport;
        do {
            arrAirport = airports.get(random.nextInt(airports.size()));
        } while (Objects.equals(depAirport, arrAirport));
        Double curPrice = price.get(random.nextInt(price.size()));
        Aircraft aircraft = AircraftFactory.getRandAircraft();
        Flight flight = new Flight();
        flight.setDepartureTime(departureTime);
        flight.setArrivalTime(arrivalTime);
        flight.setTotalTime(TimeUnit.MILLISECONDS.toHours(arrivalTime.getTime() - departureTime.getTime()));
        flight.setPrice(curPrice);
        flight.setDepAirport(depAirport);
        flight.setArrAirport(arrAirport);
        flight.setAircraft(aircraft);
        flight.setNumOfAvailablePlaces(aircraft.getTotalNumOfPlaces());
        return flight;
    }
}
