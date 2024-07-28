/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.RequestCreateRestauranteDTO;
import com.plazoleta.demo.application.mapper.IRestauranteMapper;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import com.plazoleta.demo.infraestructure.exception.UserNotOwnerException;
import com.plazoleta.demo.infraestructure.externalService.UserClient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class RestauranteHandler implements IRestauranteHandler {
    private final IRestauranteServicePort restauranteServicePort;
    private final IRestauranteMapper restauranteMapper;
    private final UserClient userClient;

    public RestauranteHandler(IRestauranteServicePort restauranteServicePort,
                              IRestauranteMapper restauranteMapper,
                              UserClient userClient) {
        this.restauranteServicePort = restauranteServicePort;
        this.restauranteMapper = restauranteMapper;
        this.userClient = userClient;
    }
    
    public void createRestaurante(RequestCreateRestauranteDTO restauranteDTO)
    {
        RestauranteModel restaurante = restauranteMapper.toModel(restauranteDTO);

        boolean isValidOwner = isOwnerUserRol(restaurante.getId_propietario());
        
        if(!isValidOwner) throw new UserNotOwnerException();
        
        restauranteServicePort.saveRestaurante(restaurante);
    }
    
    public Page<RestauranteModel> getRestaurants(int page, int size)
    {
        return restauranteServicePort.getRestaurants(page, size);
    }
    
    private Boolean isOwnerUserRol(Long id_propietario)
    {
        return userClient.getOwnerById(id_propietario);
    }
}
