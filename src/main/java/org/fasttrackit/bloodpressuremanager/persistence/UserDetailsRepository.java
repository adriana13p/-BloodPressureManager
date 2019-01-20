package org.fasttrackit.bloodpressuremanager.persistence;

import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDetailsRepository
        extends
        PagingAndSortingRepository<UserDetails, Long> {
}
