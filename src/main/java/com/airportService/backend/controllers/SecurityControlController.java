package com.airportService.backend.controllers;

import com.airportService.backend.models.SecurityControl;
import com.airportService.backend.services.SecurityControlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SecurityControlController {
    @Autowired
    private final SecurityControlServiceImpl securityControlService;

    public SecurityControlController(SecurityControlServiceImpl securityControlService) {
        this.securityControlService = securityControlService;
    }

    public void addRecord(SecurityControl securityControl) {
        securityControlService.addRecord(securityControl);
    }

    public List<SecurityControl> findAll() {
        return securityControlService.findAll();
    }

    public void updateComments(Long id, String comments) {
        securityControlService.updateComments(id, comments);
    }

    public void updateToChecked(Long id) {
        securityControlService.updateToChecked(id);
    }

    public List<SecurityControl> getRecordByPassport(String passportNumber) {
        return securityControlService.getRecordByPassport(passportNumber);
    }

    public void delete(SecurityControl securityControlRecord) {
        securityControlService.delete(securityControlRecord);
    }
}
