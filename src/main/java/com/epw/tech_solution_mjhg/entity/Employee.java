package com.epw.tech_solution_mjhg.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String firstName;

    @Column(name = "apellido", nullable = false, length = 100)
    private String lastName;

    @Column(name = "correo", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "cargo", nullable = false, length = 100)
    private String position;

    @Column(name = "salario", nullable = false, precision = 12, scale = 2)
    private BigDecimal salary;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate hireDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamento_id", nullable = false)
    private Department department;
}
