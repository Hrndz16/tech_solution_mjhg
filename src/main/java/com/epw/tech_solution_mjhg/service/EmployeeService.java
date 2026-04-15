package com.epw.tech_solution_mjhg.service;

import java.util.List;

import com.epw.tech_solution_mjhg.dto.EmployeeRequest;
import com.epw.tech_solution_mjhg.dto.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployees();
}
