package com.epw.tech_solution_mjhg.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epw.tech_solution_mjhg.dto.EmployeeRequest;
import com.epw.tech_solution_mjhg.dto.EmployeeResponse;
import com.epw.tech_solution_mjhg.entity.Department;
import com.epw.tech_solution_mjhg.entity.Employee;
import com.epw.tech_solution_mjhg.exception.ResourceNotFoundException;
import com.epw.tech_solution_mjhg.repository.DepartmentRepository;
import com.epw.tech_solution_mjhg.repository.EmployeeRepository;
import com.epw.tech_solution_mjhg.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Department department = departmentRepository.findById(employeeRequest.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with id " + employeeRequest.getDepartmentId()));

        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPosition(employeeRequest.getPosition());
        employee.setSalary(employeeRequest.getSalary());
        employee.setHireDate(employeeRequest.getHireDate());
        employee.setDepartment(department);

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
                employee.getHireDate(),
                employee.getDepartment().getId(),
                employee.getDepartment().getName());
    }
}
