package com.epw.tech_solution_mjhg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epw.tech_solution_mjhg.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
