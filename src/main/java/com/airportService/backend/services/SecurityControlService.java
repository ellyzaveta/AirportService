package com.airportService.backend.services;

import com.airportService.backend.models.SecurityControl;

import java.util.List;

public interface SecurityControlService {
    void addRecord(SecurityControl securityControl);
    List<SecurityControl> findAll();
    void updateComments(Long id, String comments);
    void updateToChecked(Long id);
    List<SecurityControl> getRecordByPassport(String passportNumber);
}
