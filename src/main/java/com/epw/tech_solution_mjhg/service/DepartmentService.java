package com.epw.tech_solution_mjhg.service;

import java.util.List;

import com.epw.tech_solution_mjhg.dto.DepartmentRequest;
import com.epw.tech_solution_mjhg.dto.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentRequest departmentRequest);

    List<DepartmentResponse> getAllDepartments();
}
