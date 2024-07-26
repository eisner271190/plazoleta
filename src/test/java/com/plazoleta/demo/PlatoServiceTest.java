/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo;

import com.plazoleta.demo.application.services.PlatoService;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.repositories.IPlatoRepository;
import com.plazoleta.demo.domain.repositories.IRestauranteRepository;
import com.plazoleta.demo.infraestructure.dto.request.ActivePlatoModel;
import com.plazoleta.demo.infraestructure.dto.request.UpdatePlatoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlatoServiceTest {

    @Mock
    private IPlatoRepository platoRepository;

    @Mock
    private IRestauranteRepository restauranteRepository;

    private PlatoService platoService;

    private PlatoModel plato;
    private RestauranteModel restaurante;

    @BeforeEach
    void setUp() {
        platoService = new PlatoService(platoRepository, restauranteRepository);
        
        plato = new PlatoModel();
        plato.setRestaurantId(1L);
        plato.setDescripcion("Descripcion del plato");
        plato.setPrecio(100);

        restaurante = new RestauranteModel();
        restaurante.setId(1L);
        restaurante.setId_propietario(1L);
    }

    @Test
    void createPlato_validOwner_createsPlato() {
        when(restauranteRepository.findById(plato.getRestaurantId())).thenReturn(Optional.of(restaurante));
        when(platoRepository.save(any(PlatoModel.class))).thenReturn(plato);

        PlatoModel result = platoService.createPlato(1L, plato);

        assertNotNull(result);
        assertTrue(result.isActive());
        verify(platoRepository).save(plato);
    }

    @Test
    void createPlato_invalidRestaurant_throwsException() {
        when(restauranteRepository.findById(plato.getRestaurantId())).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            platoService.createPlato(1L, plato);
        });

        assertEquals("{validation.idrestaurante.invalid}", exception.getMessage());
    }

    @Test
    void createPlato_invalidOwner_throwsException() {
        restaurante.setId_propietario(2L);
        when(restauranteRepository.findById(plato.getRestaurantId())).thenReturn(Optional.of(restaurante));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            platoService.createPlato(1L, plato);
        });

        assertEquals("{validation.idrestaurante.invalidOwner}", exception.getMessage());
    }

    @Test
    void updatePlato_validId_updatesPlato() {
        UpdatePlatoModel update = new UpdatePlatoModel();
        update.setId(1L);
        update.setDescripcion("Updated Description");
        update.setPrecio(150);

        when(platoRepository.findById(update.getId())).thenReturn(Optional.of(plato));
        when(platoRepository.save(any(PlatoModel.class))).thenReturn(plato);

        PlatoModel result = platoService.updatePlato(update);

        assertNotNull(result);
        assertEquals("Updated Description", result.getDescripcion());
        assertEquals(150.0, result.getPrecio());
        verify(platoRepository).save(plato);
    }

    @Test
    void updatePlato_invalidId_throwsException() {
        UpdatePlatoModel update = new UpdatePlatoModel();
        update.setId(1L);

        when(platoRepository.findById(update.getId())).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            platoService.updatePlato(update);
        });

        assertEquals("{validation.plato.invalid}", exception.getMessage());
    }

    @Test
    void activePlato_validIdAndOwner_activatesPlato() {
        ActivePlatoModel update = new ActivePlatoModel();
        update.setId(1L);
        update.setId_propietario(1L);
        update.setValor(true);

        when(platoRepository.findById(update.getId())).thenReturn(Optional.of(plato));
        when(restauranteRepository.findById(plato.getRestaurantId())).thenReturn(Optional.of(restaurante));
        when(platoRepository.save(any(PlatoModel.class))).thenReturn(plato);

        PlatoModel result = platoService.activePlato(update);

        assertNotNull(result);
        assertTrue(result.isActive());
        verify(platoRepository).save(plato);
    }

    @Test
    void activePlato_invalidId_throwsException() {
        ActivePlatoModel update = new ActivePlatoModel();
        update.setId(1L);

        when(platoRepository.findById(update.getId())).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            platoService.activePlato(update);
        });

        assertEquals("{validation.plato.invalid}", exception.getMessage());
    }

    @Test
    void activePlato_invalidOwner_throwsException() {
        ActivePlatoModel update = new ActivePlatoModel();
        update.setId(1L);
        update.setId_propietario(2L);

        when(platoRepository.findById(update.getId())).thenReturn(Optional.of(plato));
        when(restauranteRepository.findById(plato.getRestaurantId())).thenReturn(Optional.of(restaurante));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            platoService.activePlato(update);
        });

        assertEquals("{validation.plato.invalidOwner}", exception.getMessage());
    }
}
