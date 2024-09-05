package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
