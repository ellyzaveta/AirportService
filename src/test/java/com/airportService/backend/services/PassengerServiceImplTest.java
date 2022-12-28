package com.airportService.backend.services;

import com.airportService.backend.models.Passenger;
import com.airportService.backend.repositories.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class PassengerServiceImplTest {

    @Mock
    private PassengerRepository passengerRepository;

    private PassengerServiceImpl passengerService;

    @BeforeEach
    void initUseCase() {
        MockitoAnnotations.initMocks(this);
        passengerService = new PassengerServiceImpl(passengerRepository);
    }

    //тест пошуку пасажира за ID
    @Test
    public void findPassengerById() {
        //передумова
        Passenger passenger = new Passenger();

        //імітація виконання репозиторієм необхідної дії
        when(passengerRepository.findById(anyLong())).thenReturn(Optional.of(passenger));

        //дія, яка перевіряється
        Passenger result = passengerService.findById(1L);

        //перевірка коректності виконання
        assertThat(result).isNotNull();
    }

    //тест пошуку всіх пасажирів
    @Test
    void findAll() {
        //передумова
        Passenger passenger = new Passenger();
        passenger.setFirstName("first name");
        passenger.setLastName("last name");
        passenger.setBirthDate(LocalDate.now());
        passenger.setPassportNumber("bb123456");
        passenger.setCountryOfResidents("uk");
        passenger.setCountryOfResidents("uk");

        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger);

        //імітація виконання репозиторієм необхідної дії
        when(passengerRepository.findAll()).thenReturn(passengerList);

        //дія, яка перевіряється
        List<Passenger> foundPassengers = passengerService.findAll();

        //перевірка коректності виконання
        assertThat(foundPassengers.size()).isGreaterThan(0);
    }

    //тест пошуку пасажира за номером паспорта
    @Test
    void findByPassportNumber() {
        //передумова
        Passenger passenger = new Passenger();
        passenger.setFirstName("first name");
        passenger.setLastName("last name");
        passenger.setBirthDate(LocalDate.now());
        passenger.setPassportNumber("bb123456");
        passenger.setCountryOfResidents("uk");
        passenger.setCountryOfResidents("uk");

        //імітація виконання репозиторієм необхідної дії
        when(passengerRepository.findByPassportNumber(anyString())).thenReturn(passenger);

        //дія, яка перевіряється
        Passenger foundPassenger = passengerService.findByPassportNumber("1234");

        //перевірка коректності виконання
        assertThat(foundPassenger).isNotNull();
    }
}