package com.airportService.backend.data;

import com.airportService.backend.controllers.*;
import com.airportService.backend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Controller
public class DataFactory {
    @Autowired
    private final FlightController flightController;
    @Autowired
    private final AircraftController aircraftController;
    @Autowired
    private final SeatController seatController;
    @Autowired
    private final SeatPlaceController seatPlaceController;
    @Autowired
    private final UserController userController;
    @Autowired
    private final AuthenticationController authenticationController;
    @Autowired
    private final LuggageTypeController luggageTypeController;

    private static final File seats94 = new File("seats94.txt");
    private static final File seats106 = new File("seats106.txt");
    private static final File seats124 = new File("seats124.txt");
    private static final File seats142 = new File("seats142.txt");

    public DataFactory(FlightController flightController, AircraftController aircraftController, SeatController seatController, SeatPlaceController seatPlaceController, UserController userController, AuthenticationController authenticationController, LuggageTypeController luggageTypeController) {
        this.flightController = flightController;
        this.aircraftController = aircraftController;
        this.seatController = seatController;
        this.seatPlaceController = seatPlaceController;
        this.userController = userController;
        this.authenticationController = authenticationController;
        this.luggageTypeController = luggageTypeController;
    }

    public void addFlight(int opt) throws IOException {
        Flight flight = (opt == 0 ) ? FlightFactory.getRandFlight() : FlightFactory.getRandFlightIn2Hours();
        Aircraft aircraft = flight.getAircraft();

        aircraftController.addAircraft(aircraft);

        flightController.addFlight(flight);

        BufferedReader br;
        switch (aircraft.getTotalNumOfPlaces()) {
            case 94 : {
                br = new BufferedReader(new FileReader(seats94));
                break;
            }
            case 106 : {
                br = new BufferedReader(new FileReader(seats106));
                break;
            }
            case 124 : {
                br = new BufferedReader(new FileReader(seats124));
                break;
            }
            case 142 : {
                br = new BufferedReader(new FileReader(seats142));
            }
            default: {
                br = new BufferedReader(new FileReader(seats142));
            }
        };

        String st;

        while ((st = br.readLine()) != null){
            String[] words = st.split("\\W+");
            Seat seat = new Seat();
            seat.setSeatNumber(words[0]);
            seat.setSeatClass(words[1]);
            seat.setAircraft(aircraft);
            SeatPlace seatPlace = new SeatPlace();
            seatPlace.setSeat(seat);
            seatPlace.setFlight(flight);
            seatPlace.setSeatNumber(seat.getSeatNumber());
            seatController.addSeat(seat);
            seatPlaceController.addSeatPlace(seatPlace);
        }
    }

    public void setUsers() {
        userController.set(Role.RegistrationAgent, authenticationController.encode("rr1111"));
        userController.set(Role.Manager, authenticationController.encode("mm1111"));
        userController.set(Role.SecurityOfficer, authenticationController.encode("ss1111"));
    }

    public void setLuggageTypes() {
        LuggageType luggageType = new LuggageType();
        luggageType.setLuggageType("wheeled luggage");
        luggageTypeController.addLuggageType(luggageType);
        luggageType = new LuggageType();
        luggageType.setLuggageType("carry-on luggage");
        luggageTypeController.addLuggageType(luggageType);
        luggageType = new LuggageType();
        luggageType.setLuggageType("other");
        luggageTypeController.addLuggageType(luggageType);
    }

    public void init() {
        setUsers();
        setLuggageTypes();
    }

}
