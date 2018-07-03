package com.codegym.service;

import com.codegym.model.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    Group save(Group group);

    Group findById(Long id);

    Page<Group> findAll(Pageable pageable);

}
