/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.services;

import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.repositories.IPlatoRepository;
import com.plazoleta.demo.domain.repositories.IRestauranteRepository;
import com.plazoleta.demo.infraestructure.dto.request.ActivePlatoModel;
import com.plazoleta.demo.infraestructure.dto.request.UpdatePlatoModel;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@RequiredArgsConstructor
public class PlatoService {
    private final IPlatoRepository platoRepository;
    private final IRestauranteRepository restauranteRepository;
    
    public PlatoModel createPlato(Long ownerId, @Valid PlatoModel plato) {
        
        Optional<RestauranteModel> restaurante = restauranteRepository.findById(plato.getRestaurantId());
        
        if (restaurante.isEmpty())
        {
            throw new IllegalArgumentException("{validation.idrestaurante.invalid}");
        }
        
        if(!ownerId.equals(restaurante.get().getId_propietario()))
        {
            throw new IllegalArgumentException("{validation.idrestaurante.invalidOwner}");
        }
        
        plato.setActive(true);
        
        return platoRepository.save(plato);
    }
    
    public PlatoModel updatePlato(UpdatePlatoModel update) {
        
        Optional<PlatoModel> response = platoRepository.findById(update.getId());
        
        if (response.isEmpty())
        {
            throw new IllegalArgumentException("{validation.plato.invalid}");
        }
        
        PlatoModel plato = response.get();
        
        plato.setDescripcion(update.getDescripcion());
        plato.setPrecio(update.getPrecio());
        
        return platoRepository.save(plato);
    }
    
    public PlatoModel activePlato(ActivePlatoModel update) {
        
        Optional<PlatoModel> response = platoRepository.findById(update.getId());
        
        if (response.isEmpty())
        {
            throw new IllegalArgumentException("{validation.plato.invalid}");
        }
        
        PlatoModel plato = response.get();
        
        Optional<RestauranteModel> responseRestaurante = restauranteRepository.findById(plato.getRestaurantId());
        
        if(!responseRestaurante.get().getId_propietario().equals(update.getId_propietario()))
        {
            throw new IllegalArgumentException("{validation.plato.invalidOwner}");
        }
        
        plato.setActive(update.getValor());
        
        return platoRepository.save(plato);
    }
}
