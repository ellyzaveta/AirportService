package com.airportService.backend.repositories;

import com.airportService.backend.models.PassportControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PassportControlRepository extends JpaRepository<PassportControl, Long> {
    @Modifying
    @Transactional
    @Query("update PassportControl p set p.comments =:comments where p.id = :id")
    void updateComments(@Param("id") Long id, @Param("comments") String comments);

    @Modifying
    @Transactional
    @Query("update PassportControl p set p.checkResult = true where p.id = :id")
    void updateToChecked(@Param("id") Long id);

    @Query("select p from PassportControl p where p.passenger.passportNumber =:passport")
    List<PassportControl> getRecordByPassport(@Param("passport") String passportNumber);
}
