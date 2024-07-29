/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.domain.usecase;

import com.plazoleta.demo.application.dto.RequestSearchPlatoDTO;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.persistence.IPlatoPersistenceServicePort;
import com.plazoleta.demo.domain.ports.IPlatoServicePort;
import org.springframework.data.domain.Page;

/**
 *
 * @author usuario
 */
public class PlatoUseCase implements IPlatoServicePort {

    private final IPlatoPersistenceServicePort platoPersistenceServicePort;

    public PlatoUseCase(IPlatoPersistenceServicePort platoPersistenceServicePort) {
        this.platoPersistenceServicePort = platoPersistenceServicePort;
    }

    @Override
    public PlatoModel findById(Long id) {
        return platoPersistenceServicePort.findById(id);
    }

    @Override
    public void savePlato(PlatoModel plato) {
        platoPersistenceServicePort.savePlato(plato);
    }

    @Override
    public Page<PlatoModel> getPlatos(RequestSearchPlatoDTO request) {
        return platoPersistenceServicePort.getPlatos(request);
    }
}
