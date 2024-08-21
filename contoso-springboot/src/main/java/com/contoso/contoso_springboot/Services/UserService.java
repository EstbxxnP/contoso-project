package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final DepartamentService departamentService;
    private List<User> users = new ArrayList<>();

    public UserService(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getIdUser(Long id) {
        return users.stream().filter(user -> user.getIdUsuario().equals(id)).findFirst().orElse(null);
    }


    public User addUser(User user) {
        Optional<User> existingUser = users.stream().filter(u -> u.getIdUsuario().equals(user.getIdUsuario())).findFirst();

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User already exist! " + "Id user: " + user.getIdUsuario());
        }
        user.setDepartament(departamentService.getIdByDepartament(user.getIdDepartament()));

        users.add(user);
        return user;
    }



    public void updateUser(Long id, User updatedUser) {
        User user = getIdUser(id);
        if (user != null) {
            user.setNombre(updatedUser.getNombre());
            user.setApellido(updatedUser.getApellido());
            user.setCargo(updatedUser.getCargo());
            user.setDireccion(updatedUser.getDireccion());
            user.setTelefono(updatedUser.getTelefono());
            user.setCiudadResidencia(updatedUser.getCiudadResidencia());
            user.setEstadoUsuario(updatedUser.getEstadoUsuario());
            user.setSalario(updatedUser.getSalario());
            user.setDepartamento(updatedUser.getDepartamento());
        }
    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getIdUsuario().equals(id));
    }



    public List<User> getUsersByCompany(Long IdCompany){

        return users.stream().filter(u -> u.getDepartamento().getCompany().getIdCompania().equals(IdCompany)).collect(Collectors.toList());

    }

}
