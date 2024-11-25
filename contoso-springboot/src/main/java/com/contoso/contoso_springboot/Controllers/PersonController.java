package com.contoso.contoso_springboot.Controllers;

import com.contoso.contoso_springboot.Models.Person;
import com.contoso.contoso_springboot.Repositories.PersonRepository;
import com.contoso.contoso_springboot.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @PostMapping("/save")
    public void savePerson(@RequestBody Person person){
        personService.savePerson(person);
    }

    @PostMapping("/update")
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }
}
