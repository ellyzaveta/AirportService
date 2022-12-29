package com.airportService.backend.services;

import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.repositories.BoardingPassRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardingPassRepositoryTest {
    @Autowired
    private BoardingPassRepository boardingPassRepository;

    private BoardingPass boardingPass;

    @Before
    public void init() {
        boardingPass = new BoardingPass();
        boardingPass.setQrCode("123456");
    }

    //тест операції збереження посадкового талону
    @Test
    public void addBoardingPass() {
        //передумова
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setQrCode("111111");

        //дія, яка перевіряється
        BoardingPass addedBoardingPass = boardingPassRepository.save(boardingPass);

        //перевірка коректності виконання
        assertThat(addedBoardingPass).isNotNull();
        assertThat(addedBoardingPass.getId()).isGreaterThan(0);

    }

    //тест пошуку посадкового талону за ID
    @Test
    public void findBoardingPassById() {
        //передумова
        boardingPassRepository.save(boardingPass);

        //дія, яка перевіряється
        BoardingPass foundBoardingPass = boardingPassRepository.findById(boardingPass.getId()).get();

        //перевірка коректності виконання
        assertThat(foundBoardingPass).isNotNull();
    }

    //тест пошуку всіх посадкових талонів
    @Test
    public void findAllBoardingPasses() {
        //передумова
        BoardingPass boardingPass1 = new BoardingPass();
        boardingPass1.setQrCode("222222");

        boardingPassRepository.save(boardingPass);
        boardingPassRepository.save(boardingPass1);

        //дія, яка перевіряється
        List<BoardingPass> boardingPassList = boardingPassRepository.findAll();

        //перевірка коректності виконання
        assertThat(boardingPassList).isNotNull();
    }

    //тест видалення посадкового талону
    @Test
    public void deleteBoardingPass() {
        //передумова
        boardingPassRepository.save(boardingPass);

        //дія, яка перевіряється
        boardingPassRepository.delete(boardingPass);
        Optional<BoardingPass> foundBoardingPass = boardingPassRepository.findById(boardingPass.getId());

        //перевірка коректності виконання
        assertThat(foundBoardingPass).isEmpty();
    }

    //тест маркування посадкового талону як перевіреного
    @Test
    public void setIsCheckedToTrue() {
        //передумова
        BoardingPass boardingPass1 = new BoardingPass();
        boardingPass1.setQrCode("333333");

        boardingPassRepository.save(boardingPass1);
        boardingPassRepository.setIsCheckedToTrue(boardingPass1.getId());

        //дія, яка перевіряється
        BoardingPass foundedBoardingPass = boardingPassRepository.findById(boardingPass1.getId()).get();

        //перевірка коректності виконання
        assertThat(foundedBoardingPass.isChecked()).isTrue();
    }
}