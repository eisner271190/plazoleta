/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.RequestCreateRestauranteDTO;
import com.plazoleta.demo.application.dto.ResponseRestauranteDTO;
import com.plazoleta.demo.application.mapper.IRestauranteMapper;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import com.plazoleta.demo.infraestructure.exception.UserNotOwnerException;
import com.plazoleta.demo.infraestructure.externalService.UserClient;
import com.plazoleta.demo.infraestructure.jpa.mapper.RestaurantePageMapper;
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
    private final RestaurantePageMapper restaurantePageMapper;
    private final UserClient userClient;

    public RestauranteHandler(IRestauranteServicePort restauranteServicePort,
                              IRestauranteMapper restauranteMapper,
                              RestaurantePageMapper restaurantePageMapper,
                              UserClient userClient) {
        this.restauranteServicePort = restauranteServicePort;
        this.restauranteMapper = restauranteMapper;
        this.restaurantePageMapper = restaurantePageMapper;
        this.userClient = userClient;
    }
    
    public void createRestaurante(RequestCreateRestauranteDTO restauranteDTO)
    {
        RestauranteModel restaurante = restauranteMapper.toModel(restauranteDTO);

        boolean isValidOwner = isOwnerUserRol(restaurante.getId_propietario());
        
        if(!isValidOwner) throw new UserNotOwnerException();
        
        restauranteServicePort.saveRestaurante(restaurante);
    }
    
    public Page<ResponseRestauranteDTO> getRestaurants(int page, int size)
    {
        var model = restauranteServicePort.getRestaurants(page, size);
        Page<ResponseRestauranteDTO> response = restaurantePageMapper.toDTOPage(model);
        return response;
    }
    
    private Boolean isOwnerUserRol(Long id_propietario)
    {
        return userClient.getOwnerById(id_propietario);
    }
}
