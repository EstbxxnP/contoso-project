package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.Departament;
import com.contoso.contoso_springboot.Repositories.DepartamentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class DepartamentServiceTest {

    @InjectMocks
    private DepartamentService departamentService;

    @Mock
    private DepartamentRepository departamentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveDepartamentTest() {

        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Seguridad");

        when(departamentRepository.save(ArgumentMatchers.any(Departament.class))).thenAnswer(invocation -> invocation.getArgument(0));
        departamentService.addDepartament(departament);
        verify(departamentRepository, times(1)).save(departament);
    }

    @Test
    void deleteDepartamentTest() {
        Long id = 1L;

        doNothing().when(departamentRepository).deleteById(id);
        departamentService.deleteDepartament(id);
        verify(departamentRepository, times(1)).deleteById(id);
    }


    @Test
    void getDepartamentsTest() {

        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Seguridad");

        given(departamentRepository.findAll()).willReturn(Arrays.asList(departament));

        List<Departament> departaments = departamentService.getDepartaments();

        assertThat(departaments)
                .isNotEmpty()
                .extracting(Departament::getDescription)
                .contains("Seguridad");
    }

    @Test
    void getDepartamentByIdTest() {

        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Marketing");

        given(departamentRepository.findById(departament.getIdDepartament())).willReturn(Optional.of(departament));

        Optional<Departament> userNotFound = departamentService.getDepartamentById(departament.getIdDepartament());

        assertThat(userNotFound).isPresent();
        assertThat(userNotFound.get().getDescription()).isEqualTo("Marketing");
    }

    @Test
    void updateDepartament() {
        Long departamentId = 1L;

        Departament departament = new Departament();
        departament.setIdDepartament(departamentId);
        departament.setDescription("Salud");

        Departament updatedDepartament = new Departament();
        updatedDepartament.setIdDepartament(departamentId);
        updatedDepartament.setDescription("Salud");

        given(departamentRepository.findById(departamentId)).willReturn(Optional.of(departament));
        given(departamentRepository.save(updatedDepartament)).willReturn(updatedDepartament);

        departamentService.updateDepartament(updatedDepartament);

        assertThat(updatedDepartament.getDescription()).isEqualTo("Salud");
        verify(departamentRepository).save(updatedDepartament);

    }
}

