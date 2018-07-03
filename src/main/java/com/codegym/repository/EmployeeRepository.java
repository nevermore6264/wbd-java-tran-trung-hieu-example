package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);

    Employee findByName(String name);

    Page<Employee> findAllByNameContains(String name, Pageable pageable);
}
