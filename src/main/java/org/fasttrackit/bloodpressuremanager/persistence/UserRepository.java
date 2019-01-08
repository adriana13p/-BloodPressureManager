package org.fasttrackit.bloodpressuremanager.persistence;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository
        extends
        PagingAndSortingRepository<User, Long> {
}
