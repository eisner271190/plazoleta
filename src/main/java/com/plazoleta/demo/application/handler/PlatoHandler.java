/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.ActivePlatoDTO;
import com.plazoleta.demo.application.dto.RequestCreatePlatoDTO;
import com.plazoleta.demo.application.dto.UpdatePlatoDTO;
import com.plazoleta.demo.application.mapper.IPlatoMapper;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.ports.IPlatoServicePort;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import com.plazoleta.demo.infraestructure.exception.InvalidOwnerException;
import com.plazoleta.demo.infraestructure.exception.InvalidOwnerPlatoException;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class PlatoHandler implements IPlatoHandler {
    private final IPlatoServicePort platoServicePort;
    private final IPlatoMapper platoMapper;
    private final IRestauranteServicePort restauranteServicePort;

    public PlatoHandler(IPlatoServicePort platoServicePort,
                        IPlatoMapper platoMapper,
                        IRestauranteServicePort restauranteServicePort) {
        this.platoServicePort = platoServicePort;
        this.platoMapper = platoMapper;
        this.restauranteServicePort = restauranteServicePort;
    }
    
    public void createPlato(RequestCreatePlatoDTO platoDTO) {
        
        RestauranteModel restaurante = restauranteServicePort.findById(platoDTO.getRestaurantId());

        if(!platoDTO.getOwnerId().equals(restaurante.getId_propietario())) throw new InvalidOwnerException();
        
        platoDTO.setActive(true);

        PlatoModel plato = platoMapper.toModel(platoDTO);
        
        platoServicePort.savePlato(plato);
    }
    
    public void updatePlato(UpdatePlatoDTO update) {
        
        PlatoModel plato = platoServicePort.findById(update.getId());
        
        plato.setDescripcion(update.getDescripcion());
        plato.setPrecio(update.getPrecio());

        platoServicePort.savePlato(plato);
    }
    
    public void activePlato(ActivePlatoDTO update) {

        PlatoModel plato = platoServicePort.findById(update.getId());

        RestauranteModel restaurante = restauranteServicePort.findById(plato.getRestaurantId());

        if(!restaurante.getId_propietario().equals(update.getId_propietario())) throw new InvalidOwnerPlatoException();
        
        plato.setActive(update.getValor());
        
        platoServicePort.savePlato(plato);
    }
}
