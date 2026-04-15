package com.epw.tech_solution_mjhg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    @NotBlank(message = "El nombre del departamento es obligatorio")
    @Size(max = 100, message = "El nombre del departamento no puede superar los 100 caracteres")
    private String name;

    @Size(max = 255, message = "La descripcion no puede superar los 255 caracteres")
    private String description;
}
