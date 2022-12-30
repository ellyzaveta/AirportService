package com.airportService.backend.services;

import com.airportService.backend.models.PassportControl;

import java.util.List;

public interface PassportControlService {
    void addRecord(PassportControl passportControl);
    List<PassportControl> findAll();
    void updateComments(Long id, String comments);
    void updateToChecked(Long id);
    List<PassportControl> getRecordByPassport(String passportNumber);
    void delete(PassportControl passportControlRecord);
}
