package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentService {

    @Autowired
    private CompanyService companyService;

    private HashMap<Long, Departament> departaments = new HashMap<>();

    public List<Departament> getDepartaments() {
        return departaments.values().stream().collect(Collectors.toList());
    }


    public Departament getIdDepartament(Long id) {
        Departament departamento = departaments.get(id);
        if (departamento == null) {
            throw new IllegalArgumentException("Departamento no encontrado con ID: " + id);
        }
        return departamento;
    }


    public Departament addDepartament(Departament departament) {
        departament.setCompany(companyService.getCompanyById(departament.getIdCompany()));
        if (departaments.containsKey(departament.getIdDepartamento())) {
            throw new IllegalArgumentException("ID departament already exist! " + departament.getIdDepartamento());
        }
        departaments.put(departament.getIdDepartamento(), departament);
        return departament;
    }



    public void updateDepartament(Long id, Departament updatedDepartament) {
        Departament departament = getIdDepartament(id);
        if (departament != null) {
            departament.setDescripcion(updatedDepartament.getDescripcion());
        }
    }

    public void deleteDepartament(Long id) {
        if (!departaments.containsKey(id)) {
            throw new IllegalArgumentException("Departamento no encontrado con ID: " + id);
        }
        departaments.remove(id);
    }
}
