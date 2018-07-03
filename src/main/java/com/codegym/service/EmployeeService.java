package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee findById(Long id);

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    boolean existName(String name);

    void delete(Long id);

    Page<Employee> findAllByNameContains(String name, Pageable pageable);

}
