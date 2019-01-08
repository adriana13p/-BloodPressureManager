package org.fasttrackit.bloodpressuremanager.persistence;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BloodPressureRepository
        extends
        PagingAndSortingRepository<BloodPressure, Long> {
}
