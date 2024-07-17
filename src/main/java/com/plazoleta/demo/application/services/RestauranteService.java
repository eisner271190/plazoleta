/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.services;

import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.repositories.IRestauranteRepository;
import com.plazoleta.demo.infraestructure.rest.WebClientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class RestauranteService {
    @Autowired
    private IRestauranteRepository restauranteRepository;
    private final WebClientClient webClientClient;
    
    public RestauranteService(WebClientClient webClientClient)
    {
        this.webClientClient = webClientClient;
    }
    
    public void createRestaurante(RestauranteModel restaurante)
    {
        if(!isOwnerUserRol(restaurante.getId_propietario()))
        {
            throw new IllegalArgumentException("{validation.id_propietario.notvalid}");
        }
        
        restauranteRepository.save(restaurante);
    }
    
    private Boolean isOwnerUserRol(int id_propietario)
    {
        return webClientClient.fetchDataFromApi("").block();
    }
}
