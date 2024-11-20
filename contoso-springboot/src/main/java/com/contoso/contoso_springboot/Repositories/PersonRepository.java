package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
