package com.airportService.backend.controllers;

import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.models.LuggageType;
import com.airportService.backend.services.BoardingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoardingController {
    @Autowired
    private final BoardingServiceImpl boardingService;

    public BoardingController(BoardingServiceImpl boardingService) {
        this.boardingService = boardingService;
    }

    public void addLuggageType(LuggageType luggageType) {
        boardingService.addLuggageType(luggageType);
    }

    public LuggageType findLuggageTypeById(Long id) {
        return boardingService.findLuggageTypeById(id);
    }

    public void addBoardingPass(BoardingPass boardingPass) {
        boardingService.addBoardingPass(boardingPass);
    }
}
