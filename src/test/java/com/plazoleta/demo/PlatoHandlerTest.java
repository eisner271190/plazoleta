package com.plazoleta.demo;

import com.plazoleta.demo.application.dto.ActivePlatoDTO;
import com.plazoleta.demo.application.dto.RequestCreatePlatoDTO;
import com.plazoleta.demo.application.dto.UpdatePlatoDTO;
import com.plazoleta.demo.application.handler.IPlatoHandler;
import com.plazoleta.demo.application.handler.PlatoHandler;
import com.plazoleta.demo.application.mapper.IPlatoMapper;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.ports.IPlatoServicePort;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import com.plazoleta.demo.infraestructure.exception.InvalidOwnerException;
import com.plazoleta.demo.infraestructure.exception.InvalidOwnerPlatoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlatoHandlerTest {

    @Mock
    private IPlatoServicePort platoServicePort;

    @Mock
    private IPlatoMapper platoMapper;

    @Mock
    private IRestauranteServicePort restauranteServicePort;

    private IPlatoHandler platoHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        platoHandler = new PlatoHandler(platoServicePort, platoMapper, restauranteServicePort);
    }

    @Test
    public void testCreatePlato_Success() {
        RequestCreatePlatoDTO platoDTO = new RequestCreatePlatoDTO();
        platoDTO.setRestaurantId(1L);
        platoDTO.setOwnerId(1L);

        RestauranteModel restaurante = new RestauranteModel();
        restaurante.setId_propietario(1L);

        PlatoModel platoModel = new PlatoModel();

        when(restauranteServicePort.findById(platoDTO.getRestaurantId())).thenReturn(restaurante);
        when(platoMapper.toModel(platoDTO)).thenReturn(platoModel);

        platoHandler.createPlato(platoDTO);

        verify(platoServicePort).savePlato(platoModel);
    }

    @Test
    public void testCreatePlato_InvalidOwner() {
        RequestCreatePlatoDTO platoDTO = new RequestCreatePlatoDTO();
        platoDTO.setRestaurantId(1L);
        platoDTO.setOwnerId(2L);

        RestauranteModel restaurante = new RestauranteModel();
        restaurante.setId_propietario(1L);

        when(restauranteServicePort.findById(platoDTO.getRestaurantId())).thenReturn(restaurante);

        assertThrows(InvalidOwnerException.class, () -> platoHandler.createPlato(platoDTO));
    }

    @Test
    public void testUpdatePlato_Success() {
        UpdatePlatoDTO updateDTO = new UpdatePlatoDTO();
        updateDTO.setId(1L);
        updateDTO.setDescripcion("New Description");
        updateDTO.setPrecio(20);

        PlatoModel platoModel = new PlatoModel();

        when(platoServicePort.findById(updateDTO.getId())).thenReturn(platoModel);

        platoHandler.updatePlato(updateDTO);

        assertEquals("New Description", platoModel.getDescripcion());
        assertEquals(20.0, platoModel.getPrecio());
        verify(platoServicePort).savePlato(platoModel);
    }

    @Test
    public void testActivePlato_Success() {
        ActivePlatoDTO activeDTO = new ActivePlatoDTO();
        activeDTO.setId(1L);
        activeDTO.setValor(true);
        activeDTO.setId_propietario(1L);

        PlatoModel platoModel = new PlatoModel();
        platoModel.setRestaurantId(1L);

        RestauranteModel restaurante = new RestauranteModel();
        restaurante.setId_propietario(1L);

        when(platoServicePort.findById(activeDTO.getId())).thenReturn(platoModel);
        when(restauranteServicePort.findById(platoModel.getRestaurantId())).thenReturn(restaurante);

        platoHandler.activePlato(activeDTO);

        assertTrue(platoModel.isActive());
        verify(platoServicePort).savePlato(platoModel);
    }

    @Test
    public void testActivePlato_InvalidOwner() {
        ActivePlatoDTO activeDTO = new ActivePlatoDTO();
        activeDTO.setId(1L);
        activeDTO.setValor(true);
        activeDTO.setId_propietario(2L);

        PlatoModel platoModel = new PlatoModel();
        platoModel.setRestaurantId(1L);

        RestauranteModel restaurante = new RestauranteModel();
        restaurante.setId_propietario(1L);

        when(platoServicePort.findById(activeDTO.getId())).thenReturn(platoModel);
        when(restauranteServicePort.findById(platoModel.getRestaurantId())).thenReturn(restaurante);

        assertThrows(InvalidOwnerPlatoException.class, () -> platoHandler.activePlato(activeDTO));
    }
}
