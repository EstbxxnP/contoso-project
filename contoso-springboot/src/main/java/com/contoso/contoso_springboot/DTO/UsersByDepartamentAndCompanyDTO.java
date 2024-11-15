package com.contoso.contoso_springboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersByDepartamentAndCompanyDTO {

    private String departament;
    private String company;
    private Long numberOfUsers;

}
