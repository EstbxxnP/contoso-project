package com.contoso.contoso_springboot.Controllers;


import com.contoso.contoso_springboot.Models.Departament;
import com.contoso.contoso_springboot.Services.DepartamentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departaments")
public class DepartamentController {

    @Autowired
    private DepartamentService departamentService;

    @GetMapping
    public List<Departament> getAllDepartaments() {
        return departamentService.getDepartaments();
    }

    @GetMapping("/{id}")
    public Departament getByIdDepartament(@PathVariable Long id) {
        return departamentService.getIdByDepartament(id);
    }

    @PostMapping
    public void addDepartament(@Valid @RequestBody Departament departament) {
        departamentService.addDepartament(departament);
    }

    @PutMapping("/{id}")
    public void uptdateDepartament(@PathVariable Long id, @RequestBody Departament departament) {
        departamentService.updateDepartament(id, departament);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartament(@PathVariable Long id) {
        departamentService.deleteDepartament(id);
    }
}

