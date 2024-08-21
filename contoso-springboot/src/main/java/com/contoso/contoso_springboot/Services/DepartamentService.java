package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartamentService {

    @Autowired
    private CompanyService companyService;

    private List<Departament> departaments = new ArrayList<>();

    public List<Departament> getDepartaments() {
        return departaments;
    }

    public Departament getIdDepartament(Long id) {
        return departaments.stream().filter(departament -> departament.getIdDepartamento().equals(id)).findFirst().orElse(null);
    }

    public void addDepartament(Departament departament) {
         departament.setCompany(companyService.getCompanyById(departament.getIdCompany()));
         departaments.add(departament);
    }

    public void updateDepartament(Long id, Departament updatedDepartament) {
        Departament departament = getIdDepartament(id);
        if (departament != null) {
            departament.setDescripcion(updatedDepartament.getDescripcion());
        }
    }

    public void deleteDepartament(Long id) {
        departaments.removeIf(departament -> departament.getIdDepartamento().equals(id));
    }
}

