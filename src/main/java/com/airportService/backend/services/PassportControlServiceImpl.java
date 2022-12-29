package com.airportService.backend.services;

import com.airportService.backend.models.PassportControl;
import com.airportService.backend.repositories.PassportControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportControlServiceImpl implements PassportControlService {
    @Autowired
    private final PassportControlRepository passportControlRepository;

    public PassportControlServiceImpl(PassportControlRepository passportControlRepository) {
        this.passportControlRepository = passportControlRepository;
    }

    @Override
    public void addRecord(PassportControl passportControl) {
        passportControlRepository.save(passportControl);
    }

    @Override
    public List<PassportControl> findAll() {
        return passportControlRepository.findAll();
    }

    @Override
    public void updateComments(Long id, String comments) {
        passportControlRepository.updateComments(id, comments);
    }

    @Override
    public void updateToChecked(Long id) {
        passportControlRepository.updateToChecked(id);
    }

    @Override
    public List<PassportControl> getRecordByPassport(String passportNumber) {
        return passportControlRepository.getRecordByPassport(passportNumber);
    }
}
