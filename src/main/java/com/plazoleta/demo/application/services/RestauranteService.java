/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.services;

import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.repositories.IPagingAndSortingRestauranteRepository;
import com.plazoleta.demo.domain.repositories.IRestauranteRepository;
import com.plazoleta.demo.infraestructure.externalService.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@RequiredArgsConstructor
public class RestauranteService {
    private final IRestauranteRepository restauranteRepository;
    private final IPagingAndSortingRestauranteRepository pagingAndSortingRestauranteRepository;
    private final UserClient userClient;
    
    public void createRestaurante(RestauranteModel restaurante)
    {
        boolean isValidOwner = isOwnerUserRol(restaurante.getId_propietario());
        
        if(!isValidOwner)
        {
            throw new IllegalArgumentException("{validation.id_propietario.notvalid}");
        }
        
        restauranteRepository.save(restaurante);
    }
    
    public Page<RestauranteModel> getRestaurants(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return pagingAndSortingRestauranteRepository.findAll(pageable);
    }
    
    private Boolean isOwnerUserRol(Long id_propietario)
    {
        return userClient.getOwnerById(id_propietario);
    }
}
