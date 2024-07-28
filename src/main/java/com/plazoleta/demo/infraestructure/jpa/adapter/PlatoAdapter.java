/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.adapter;

import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.persistence.IPlatoPersistenceServicePort;
import com.plazoleta.demo.infraestructure.exception.PlatoNotFoundException;
import com.plazoleta.demo.infraestructure.jpa.mapper.IPlatoEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPlatoRepository;

/**
 *
 * @author usuario
 */
public class PlatoAdapter implements IPlatoPersistenceServicePort {

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;

    public PlatoAdapter(IPlatoRepository platoRepository,
                        IPlatoEntityMapper platoEntityMapper) {
        this.platoRepository = platoRepository;
        this.platoEntityMapper = platoEntityMapper;
    }

    @Override
    public PlatoModel findById(Long id) {
        return platoEntityMapper.toModel(platoRepository.findById(id).orElseThrow(PlatoNotFoundException::new));
    }

    @Override
    public void savePlato(PlatoModel plato) {
        platoRepository.save(platoEntityMapper.toEntity(plato));
    }
}
