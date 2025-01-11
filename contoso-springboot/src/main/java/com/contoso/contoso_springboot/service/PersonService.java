package com.contoso.contoso_springboot.service;

import com.contoso.contoso_springboot.model.Person;
import com.contoso.contoso_springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
