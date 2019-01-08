package org.fasttrackit.bloodpressuremanager.persistence;

import org.fasttrackit.bloodpressuremanager.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository
        extends
        PagingAndSortingRepository<Person, Long> {
}
