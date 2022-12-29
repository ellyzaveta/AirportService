package com.airportService.backend.services;

import com.airportService.backend.models.SecurityControl;
import com.airportService.backend.repositories.SecurityControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityControlServiceImpl implements SecurityControlService{
    @Autowired
    private final SecurityControlRepository securityControlRepository;

    public SecurityControlServiceImpl(SecurityControlRepository securityControlRepository) {
        this.securityControlRepository = securityControlRepository;
    }

    @Override
    public void addRecord(SecurityControl securityControl) {
        securityControlRepository.save(securityControl);
    }

    @Override
    public List<SecurityControl> findAll() {
        return securityControlRepository.findAll();
    }

    @Override
    public void updateComments(Long id, String comments) {
        securityControlRepository.updateComments(id, comments);
    }

    @Override
    public void updateToChecked(Long id) {
        securityControlRepository.updateToChecked(id);
    }

    @Override
    public List<SecurityControl> getRecordByPassport(String passportNumber) {
        return securityControlRepository.getRecordByPassport(passportNumber);
    }
}
