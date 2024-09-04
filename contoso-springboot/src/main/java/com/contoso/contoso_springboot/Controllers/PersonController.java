package com.contoso.contoso_springboot.Controllers;
import com.contoso.contoso_springboot.Models.Person;
import com.contoso.contoso_springboot.Repositories.PersonRepository;
import org.apache.tomcat.jni.Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }

}
