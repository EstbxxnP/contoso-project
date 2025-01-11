package com.contoso.contoso_springboot.repository;

import com.contoso.contoso_springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
