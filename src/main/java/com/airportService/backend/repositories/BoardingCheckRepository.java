package com.airportService.backend.repositories;

import com.airportService.backend.models.BoardingCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardingCheckRepository extends JpaRepository<BoardingCheck, Long> {
    @Modifying
    @Transactional
    @Query("update BoardingCheck b set b.comments =:comments where b.id = :id")
    void updateComments(@Param("id") Long id, @Param("comments") String comments);

    @Modifying
    @Transactional
    @Query("update BoardingCheck b set b.checkResult = true where b.id = :id")
    void updateToChecked(@Param("id") Long id);

    @Query("select b from BoardingCheck b where b.boardingPass.qrCode =:qrCode")
    List<BoardingCheck> getRecordByBoardingPassQRCode(@Param("qrCode") String qrCode);
}