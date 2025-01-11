package com.contoso.contoso_springboot.controllers;

import com.contoso.contoso_springboot.model.Company;
import com.contoso.contoso_springboot.model.Departament;
import com.contoso.contoso_springboot.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/queries")
public class QueryController {

    @GetMapping("/saludo")
    public String Saludo(){return "Hola mundo";}
    @Autowired
    private QueryService queryService;
    @PostMapping("/usersByDepartament")
    public ResponseEntity<Map<String, Long>> queryUsersByDepartaments(@RequestBody List<Departament> departaments) {
        try {
            Map<String, Long> total = queryService.queryUsersByDepartament(departaments);
            return new ResponseEntity<>(total, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/departamentsByCompany")
    public ResponseEntity<Map<String, Long>> queryDepartamentsByCompany(@RequestBody List<Company> companys) {
        try {
            Map<String, Long> total = queryService.queryDepartamentsByCompany(companys);
            return new ResponseEntity<>(total, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/getExpensesByDepartament")
    public ResponseEntity<Map<String, Double>> getExpensesByDepartament(@RequestBody  List<Departament> departaments) {

        try {
            Map<String, Double> total = queryService.getExpensesByDepartament(departaments);
            return new ResponseEntity<>(total, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/getExpensesByCompany")
    public ResponseEntity <Map<String, Double>> getExpensesByCompany(@RequestBody  List<Company> companys) {
        try {
            Map<String, Double> total = queryService.getExpensesByCompany(companys);
            return new ResponseEntity<>(total, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
