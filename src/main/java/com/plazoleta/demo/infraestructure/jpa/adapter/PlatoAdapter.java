/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.adapter;

import com.plazoleta.demo.application.dto.RequestSearchPlatoDTO;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.persistence.IPlatoPersistenceServicePort;
import com.plazoleta.demo.infraestructure.exception.PlatoNotFoundException;
import com.plazoleta.demo.infraestructure.jpa.mapper.IPlatoEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.PlatoPageMapper;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPagingAndSortingPlatoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPlatoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author usuario
 */
public class PlatoAdapter implements IPlatoPersistenceServicePort {

    private final IPlatoRepository platoRepository;
    private final IPagingAndSortingPlatoRepository pagingAndSortingPlatoRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final PlatoPageMapper platoPageMapper;

    public PlatoAdapter(IPlatoRepository platoRepository,
                        IPagingAndSortingPlatoRepository pagingAndSortingPlatoRepository,
                        PlatoPageMapper platoPageMapper,
                        IPlatoEntityMapper platoEntityMapper) {
        this.platoRepository = platoRepository;
        this.pagingAndSortingPlatoRepository = pagingAndSortingPlatoRepository;
        this.platoEntityMapper = platoEntityMapper;
        this.platoPageMapper = platoPageMapper;
    }

    @Override
    public PlatoModel findById(Long id) {
        return platoEntityMapper.toModel(platoRepository.findById(id).orElseThrow(PlatoNotFoundException::new));
    }

    @Override
    public void savePlato(PlatoModel plato) {
        platoRepository.save(platoEntityMapper.toEntity(plato));
    }

    @Override
    public Page<PlatoModel> getPlatos(RequestSearchPlatoDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        if(request.getCategory() == null || request.getCategory().isBlank())
        {
            return platoPageMapper.toModelPage(pagingAndSortingPlatoRepository.findByRestaurantId(request.getIdRestaurante(), pageable));
        }

        return platoPageMapper.toModelPage(pagingAndSortingPlatoRepository.findByCategoryAndRestaurantId(request.getCategory(),request.getIdRestaurante(), pageable));
    }
}
