package com.airportService.backend.controllers;

import com.airportService.backend.models.LuggageType;
import com.airportService.backend.services.LuggageTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LuggageTypeController {
    @Autowired
    private final LuggageTypeServiceImpl luggageTypeService;

    public LuggageTypeController(LuggageTypeServiceImpl luggageTypeService) {
        this.luggageTypeService = luggageTypeService;
    }

    public void addLuggageType(LuggageType luggageType) {
        luggageTypeService.addLuggageType(luggageType);
    }

    public LuggageType findById(Long id) {
        return luggageTypeService.findById(id);
    }

    public List<LuggageType> findAll() {
        return luggageTypeService.findAll();
    }
}
