package com.contoso.contoso_springboot.service;

import com.contoso.contoso_springboot.dto.UsersByDepartamentAndCompanyDTO;
import com.contoso.contoso_springboot.model.User;
import com.contoso.contoso_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UsersByDepartamentAndCompanyDTO> usersByDepartamentAndCompany() {
        return userRepository.usersByDepartamentAndCompany();
    }
}

