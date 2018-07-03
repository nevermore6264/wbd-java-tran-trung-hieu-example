package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public boolean existName(String name) {
        Employee employee = employeeRepository.findByName(name);
        return (employee != null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Page<Employee> findAllByNameContains(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContains(name,pageable);
    }
}
