package com.epw.tech_solution_mjhg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.tech_solution_mjhg.dto.EmployeeRequest;
import com.epw.tech_solution_mjhg.dto.EmployeeResponse;
import com.epw.tech_solution_mjhg.entity.Employee;
import com.epw.tech_solution_mjhg.repository.EmployeeRepository;
import com.epw.tech_solution_mjhg.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPosition(employeeRequest.getPosition());
        employee.setSalary(employeeRequest.getSalary());
        employee.setHireDate(employeeRequest.getHireDate());

        Employee savedEmployee = employeeRepository.save(employee);
        return mapToResponse(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private EmployeeResponse mapToResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPosition(),
                employee.getSalary(),
                employee.getHireDate());
    }
}
