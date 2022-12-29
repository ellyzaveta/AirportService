package com.airportService.backend.repositories;

import com.airportService.backend.models.SecurityControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SecurityControlRepository extends JpaRepository<SecurityControl, Long> {
    @Modifying
    @Transactional
    @Query("update SecurityControl s set s.comments =:comments where s.id = :id")
    void updateComments(@Param("id") Long id, @Param("comments") String comments);

    @Modifying
    @Transactional
    @Query("update SecurityControl s set s.checkResult = true where s.id = :id")
    void updateToChecked(@Param("id") Long id);

    @Query("select s from SecurityControl s where s.passenger.passportNumber =:passport")
    List<SecurityControl> getRecordByPassport(@Param("passport") String passportNumber);
}
