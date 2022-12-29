package com.airportService;

import com.airportService.backend.data.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class AirportServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirportServiceApplication.class, args);
    }

    @Autowired
    private DataFactory dataFactory;

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() throws IOException {
//        dataFactory.init();
//        dataFactory.addFlight(1);
//        dataFactory.addFlight(1);
//        dataFactory.addFlight(0);
//        dataFactory.addFlight(0);
//        dataFactory.addFlight(0);
//        dataFactory.addFlight(0);
//        dataFactory.addFlight(0);
//        dataFactory.addFlight(0);
//        dataFactory.addFlight(0);
        // 1 - generate rand flight with departure time in the next 2 hours
        // 0 - generate rand flight
    }
}

