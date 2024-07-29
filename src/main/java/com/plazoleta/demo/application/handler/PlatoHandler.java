/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.*;
import com.plazoleta.demo.application.mapper.IPlatoMapper;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.ports.IPlatoServicePort;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import com.plazoleta.demo.infraestructure.exception.InvalidOwnerException;
import com.plazoleta.demo.infraestructure.exception.InvalidOwnerPlatoException;
import com.plazoleta.demo.infraestructure.jpa.mapper.PlatoPageMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class PlatoHandler implements IPlatoHandler {
    private final IPlatoServicePort platoServicePort;
    private final IPlatoMapper platoMapper;
    private final PlatoPageMapper platoPageMapper;
    private final IRestauranteServicePort restauranteServicePort;

    public PlatoHandler(IPlatoServicePort platoServicePort,
                        IPlatoMapper platoMapper,
                        PlatoPageMapper platoPageMapper,
                        IRestauranteServicePort restauranteServicePort) {
        this.platoServicePort = platoServicePort;
        this.platoMapper = platoMapper;
        this.platoPageMapper = platoPageMapper;
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

    public Page<ResponsePlatoDTO> getPlatos(RequestSearchPlatoDTO request)
    {
        var model = platoServicePort.getPlatos(request);
        Page<ResponsePlatoDTO> response = platoPageMapper.toDTOPage(model);
        return response;
    }
}
