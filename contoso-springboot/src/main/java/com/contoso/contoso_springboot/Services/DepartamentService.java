package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.DTO.DepartamentsByCompanysDTO;
import com.contoso.contoso_springboot.Models.Departament;
import com.contoso.contoso_springboot.Repositories.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentService {

    @Autowired
    DepartamentRepository departamentRepository;

    public List<Departament> getDepartaments() {
        return departamentRepository.findAll();}

    public Optional<Departament> getDepartamentById(Long id){
        return departamentRepository.findById(id);}

    public void addDepartament (Departament departament){
        departamentRepository.save(departament);}

    public void updateDepartament (Departament departament){
        departamentRepository.save(departament);}

    public void deleteDepartament (Long id){
        departamentRepository.deleteById(id);}

    public List<DepartamentsByCompanysDTO> countDepartamentsByCompanys() {
        return departamentRepository.countDepartamentsByCompanys();
    }
}
