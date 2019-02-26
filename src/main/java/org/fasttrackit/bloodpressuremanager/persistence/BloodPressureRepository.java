package org.fasttrackit.bloodpressuremanager.persistence;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface BloodPressureRepository
        extends
        PagingAndSortingRepository<BloodPressure, Long> {

    BloodPressure findByidBP(long idBP);

    //find all blood pressures for a specific user
    List<BloodPressure> findByUserIdUserOrderByDateBPDesc(long idUser);

    //find all blood pressures ordered descending by date for a specific user and for a specific date
    List<BloodPressure> findByUserIdUserAndDateBPOrderByDateBPDesc(long idUser, Date dateBP);

    //find all blood pressures ordered date for a specific user and for a time period
    List<BloodPressure> findByUserIdUserAndDateBPBetween(long idUser, Date dateBPStart, Date dateBPEnd);

    //find all blood pressures ordered descending by date for a specific user and for a time period
    List<BloodPressure> findByUserIdUserAndDateBPBetweenOrderByDateBPDesc(long idUser, Date dateBPStart, Date dateBPEnd);

}