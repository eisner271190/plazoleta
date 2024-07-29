package com.plazoleta.demo;

import com.plazoleta.demo.application.dto.RequestCreateRestauranteDTO;
import com.plazoleta.demo.application.handler.IRestauranteHandler;
import com.plazoleta.demo.application.handler.RestauranteHandler;
import com.plazoleta.demo.application.mapper.IRestauranteMapper;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import com.plazoleta.demo.infraestructure.exception.UserNotOwnerException;
import com.plazoleta.demo.infraestructure.externalService.UserClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RestauranteHandlerTest {

    @Mock
    private IRestauranteServicePort restauranteServicePort;

    @Mock
    private IRestauranteMapper restauranteMapper;

    @Mock
    private UserClient userClient;

    private IRestauranteHandler restauranteHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        restauranteHandler = new RestauranteHandler(restauranteServicePort, restauranteMapper, userClient);
    }

    @Test
    public void testCreateRestaurante_Success() {
        RequestCreateRestauranteDTO restauranteDTO = new RequestCreateRestauranteDTO();
        restauranteDTO.setId_propietario(1L);

        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId_propietario(1L);

        when(restauranteMapper.toModel(restauranteDTO)).thenReturn(restauranteModel);
        when(userClient.getOwnerById(restauranteDTO.getId_propietario())).thenReturn(true);

        restauranteHandler.createRestaurante(restauranteDTO);

        verify(restauranteServicePort).saveRestaurante(restauranteModel);
    }

    @Test
    public void testCreateRestaurante_InvalidOwner() {
        RequestCreateRestauranteDTO restauranteDTO = new RequestCreateRestauranteDTO();
        restauranteDTO.setId_propietario(1L);

        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId_propietario(1L);

        when(restauranteMapper.toModel(restauranteDTO)).thenReturn(restauranteModel);
        when(userClient.getOwnerById(restauranteDTO.getId_propietario())).thenReturn(false);

        assertThrows(UserNotOwnerException.class, () -> restauranteHandler.createRestaurante(restauranteDTO));
    }

    @Test
    public void testGetRestaurants_Success() {
        int page = 0;
        int size = 10;

        RestauranteModel restaurante1 = new RestauranteModel();
        RestauranteModel restaurante2 = new RestauranteModel();
        Page<RestauranteModel> pageResponse = new PageImpl<>(List.of(restaurante1, restaurante2));

        when(restauranteServicePort.getRestaurants(page, size)).thenReturn(pageResponse);

        Page<RestauranteModel> result = restauranteHandler.getRestaurants(page, size);

        assertEquals(2, result.getContent().size());
        assertEquals(restaurante1, result.getContent().get(0));
        assertEquals(restaurante2, result.getContent().get(1));
    }
}