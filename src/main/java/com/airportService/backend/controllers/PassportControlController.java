package com.airportService.backend.controllers;

import com.airportService.backend.models.PassportControl;
import com.airportService.backend.services.PassportControlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PassportControlController {
    @Autowired
    private final PassportControlServiceImpl passportControlService;

    public PassportControlController(PassportControlServiceImpl passportControlService) {
        this.passportControlService = passportControlService;
    }

    public void addRecord(PassportControl passportControl) {
        passportControlService.addRecord(passportControl);
    }

    public List<PassportControl> findAll() {
        return passportControlService.findAll();
    }

    public void updateComments(Long id, String comments) {
        passportControlService.updateComments(id, comments);
    }

    public void updateToChecked(Long id) {
        passportControlService.updateToChecked(id);
    }

    public List<PassportControl> getRecordByPassport(String passportNumber) {
        return passportControlService.getRecordByPassport(passportNumber);
    }

    public void delete(PassportControl passportControlRecord) {
        passportControlService.delete(passportControlRecord);
    }
}
