/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo;

import com.plazoleta.demo.application.services.PlatoService;
import com.plazoleta.demo.application.services.RestauranteService;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.repositories.IPagingAndSortingRestauranteRepository;
import com.plazoleta.demo.domain.repositories.IRestauranteRepository;
import com.plazoleta.demo.infraestructure.externalService.UserClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestauranteServiceTest {

    @Mock
    private IRestauranteRepository restauranteRepository;

    @Mock
    private IPagingAndSortingRestauranteRepository pagingAndSortingRestauranteRepository;

    @Mock
    private UserClient userClient;

    private RestauranteService restauranteService;

    private RestauranteModel restaurante;

    @BeforeEach
    void setUp() {
        restauranteService = new RestauranteService(restauranteRepository, pagingAndSortingRestauranteRepository, userClient);
        
        restaurante = new RestauranteModel();
        restaurante.setId(1L);
        restaurante.setNombre("Test Restaurant");
        restaurante.setId_propietario(1L);
    }

    @Test
    void createRestaurante_validOwner_savesRestaurante() {
        when(userClient.getOwnerById(restaurante.getId_propietario())).thenReturn(true);

        restauranteService.createRestaurante(restaurante);

        verify(restauranteRepository).save(restaurante);
    }

    @Test
    void createRestaurante_invalidOwner_throwsException() {
        when(userClient.getOwnerById(restaurante.getId_propietario())).thenReturn(false);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            restauranteService.createRestaurante(restaurante);
        });

        assertEquals("{validation.id_propietario.notvalid}", exception.getMessage());
    }

    @Test
    void getRestaurants_validPageable_returnsPage() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<RestauranteModel> page = new PageImpl<>(Collections.singletonList(restaurante));

        when(pagingAndSortingRestauranteRepository.findAll(pageable)).thenReturn(page);

        Page<RestauranteModel> result = restauranteService.getRestaurants(0, 10);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(pagingAndSortingRestauranteRepository).findAll(pageable);
    }
}
