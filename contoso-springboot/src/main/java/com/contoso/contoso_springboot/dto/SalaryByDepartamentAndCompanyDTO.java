package com.contoso.contoso_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryByDepartamentAndCompanyDTO {

    private String company;
    private String departament;
    private Double salary;

}
