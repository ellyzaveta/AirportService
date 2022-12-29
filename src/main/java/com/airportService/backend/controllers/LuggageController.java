package com.airportService.backend.controllers;

import com.airportService.backend.models.Luggage;
import com.airportService.backend.services.LuggageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LuggageController {
    @Autowired
    private final LuggageServiceImpl luggageService;

    public LuggageController(LuggageServiceImpl luggageService) {
        this.luggageService = luggageService;
    }

    public void addLuggage(Luggage luggage) {
        luggageService.addLuggage(luggage);
    }
}
