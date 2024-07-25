/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.services;

import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.repositories.IRestauranteRepository;
import com.plazoleta.demo.infraestructure.externalService.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@RequiredArgsConstructor
public class RestauranteService {
    private final UserClient userClient;
    private final IRestauranteRepository restauranteRepository;
    
    public void createRestaurante(RestauranteModel restaurante)
    {
        boolean isValidOwner = true;//isOwnerUserRol(restaurante.getId_propietario());
        
        if(!isValidOwner)
        {
            throw new IllegalArgumentException("{validation.id_propietario.notvalid}");
        }
        
        restauranteRepository.save(restaurante);
    }
    
    private Boolean isOwnerUserRol(Long id_propietario)
    {
        return userClient.getOwnerById(id_propietario);
    }
}
