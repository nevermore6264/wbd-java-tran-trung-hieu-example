package com.codegym.repository;

import com.codegym.model.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
    Group findByName(String name);

    Page<Group> findAll(Pageable pageable);
}
