package com.contoso.contoso_springboot.Controllers;

import com.contoso.contoso_springboot.DTO.DepartamentsByCompanysDTO;
import com.contoso.contoso_springboot.Models.Departament;
import com.contoso.contoso_springboot.Repositories.DepartamentRepository;
import com.contoso.contoso_springboot.Services.DepartamentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    public Optional<Departament> getDepartamentById(@PathVariable Long id) {
        return departamentService.getDepartamentById(id);
    }

    @PostMapping("/add")
    public void addDepartament(@Valid @RequestBody Departament departament) {
        departamentService.addDepartament(departament);
    }

    @PutMapping("/update")
    public void uptdateDepartament(@RequestBody Departament departament) {
        departamentService.updateDepartament(departament);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartament(@PathVariable Long id) {
        departamentService.deleteDepartament(id);
    }

    @GetMapping("/countDepartamentsByCompanys")
    public List<DepartamentsByCompanysDTO> countDepartamentsByCompanys() {
        return departamentService.countDepartamentsByCompanys();
    }
}

