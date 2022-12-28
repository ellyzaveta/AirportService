package com.airportService.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

@Controller
public class FillWithData {
//    @Autowired
//    private final FlightServiceController flightServiceController;
//
//    public FillWithData(FlightServiceController flightServiceController) {
//        this.flightServiceController = flightServiceController;
//    }
//
////    public void fillSeatMap(int totalNumOfPlaces) {
////        SeatMap seatMap = new SeatMap();
////        seatMap.setTotalNumOfSeats(totalNumOfPlaces);
////        seatMap.setNumOfAvailableSeats(totalNumOfPlaces);
////        flightServiceController.addSeatMap(seatMap);
////    }
//
//    public void fillSeats(String filename, Aircraft aircraft, Flight flight) throws IOException {
//        File file = new File(filename);
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String st;
//        Integer numOfPlaces = Integer.valueOf(br.readLine());
//        while ((st = br.readLine()) != null){
//            String[] words = st.split("\\W+");
//            Seat seat = new Seat();
//            seat.setSeatNumber(words[0]);
//            seat.setSeatClass(words[1]);
//            seat.setAircraft(aircraft);
//            SeatPlace seatPlace = new SeatPlace();
//            seatPlace.setSeat(seat);
//            seatPlace.setFlight(flight);
//            seatPlace.setSeatNumber(seat.getSeatNumber());
//            flightServiceController.addSeat(seat);
//            flightServiceController.addSeatPlace(seatPlace);
//
//        }
//    }
//
//    public void fillAircrafts(Double fuelPerHour, String model, Integer totalNumOfPlaces) {
//        Aircraft aircraft = new Aircraft();
//        aircraft.setModel(model);
//        aircraft.setFuelPerHour(fuelPerHour);
//        aircraft.setTotalNumOfPlaces(totalNumOfPlaces);
//        flightServiceController.addAircraft(aircraft);
//    }
//
//    public void fillFlight(Date depTime, Date arrTime, Double price, String depAirport, String arrAirport, Aircraft aircraft) {
//        Flight flight = new Flight();
//        flight.setDepartureTime(depTime);
//        flight.setArrivalTime(arrTime);
//        flight.setDepAirport(depAirport);
//        flight.setArrAirport(arrAirport);
//        flight.setPrice(price);
//        flight.setAircraft(aircraft);
//        flightServiceController.addFlight(flight);
//    }
//
//    public void fillTicket() {
//
//    }
}
