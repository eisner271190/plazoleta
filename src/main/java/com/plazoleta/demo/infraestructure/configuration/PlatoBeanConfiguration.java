/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.configuration;

import com.plazoleta.demo.domain.persistence.IPlatoPersistenceServicePort;
import com.plazoleta.demo.domain.ports.IPlatoServicePort;
import com.plazoleta.demo.domain.usecase.PlatoUseCase;
import com.plazoleta.demo.infraestructure.jpa.adapter.PlatoAdapter;
import com.plazoleta.demo.infraestructure.jpa.mapper.IPlatoEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.PlatoPageMapper;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPagingAndSortingPlatoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPlatoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author usuario
 */
@Configuration
public class PlatoBeanConfiguration {
    
    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final IPagingAndSortingPlatoRepository pagingAndSortingPlatoRepository;
    private final PlatoPageMapper platoPageMapper;

    public PlatoBeanConfiguration(IPlatoRepository platoRepository,
                                  IPlatoEntityMapper platoEntityMapper,
                                  IPagingAndSortingPlatoRepository pagingAndSortingPlatoRepository,
                                  PlatoPageMapper platoPageMapper) {
        this.platoRepository = platoRepository;
        this.platoEntityMapper = platoEntityMapper;
        this.pagingAndSortingPlatoRepository = pagingAndSortingPlatoRepository;
        this.platoPageMapper = platoPageMapper;
    }
    
    @Bean
    public IPlatoPersistenceServicePort platoPersistenceServicePort() {
        return new PlatoAdapter(platoRepository, pagingAndSortingPlatoRepository, platoPageMapper, platoEntityMapper);
    }
    
    @Bean
    public IPlatoServicePort platoServicePort() {
        return new PlatoUseCase(platoPersistenceServicePort());
    }
}
