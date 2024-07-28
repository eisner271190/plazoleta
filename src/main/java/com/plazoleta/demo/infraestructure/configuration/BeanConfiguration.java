/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.configuration;

import com.plazoleta.demo.domain.persistence.IPlatoPersistenceServicePort;
import com.plazoleta.demo.domain.persistence.IRestaurantePersistenceServicePort;
import com.plazoleta.demo.domain.ports.IPlatoServicePort;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import com.plazoleta.demo.domain.usecase.PlatoUseCase;
import com.plazoleta.demo.domain.usecase.RestauranteUseCase;
import com.plazoleta.demo.infraestructure.jpa.adapter.PlatoAdapter;
import com.plazoleta.demo.infraestructure.jpa.adapter.RestauranteAdapter;
import com.plazoleta.demo.infraestructure.jpa.mapper.IPlatoEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.IRestauranteEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.RestaurantePageMapper;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPagingAndSortingRestauranteRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPlatoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IRestauranteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author usuario
 */
@Configuration
public class BeanConfiguration {
    
    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final IPagingAndSortingRestauranteRepository pagingAndSortingRestauranteRepository;
    private final RestaurantePageMapper restaurantePageMapper;
    
    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;

    public BeanConfiguration(IRestauranteRepository restauranteRepository,
                             IRestauranteEntityMapper restauranteEntityMapper,
                             IPagingAndSortingRestauranteRepository pagingAndSortingRestauranteRepository,
                             RestaurantePageMapper restaurantePageMapper,
                             IPlatoRepository platoRepository,
                             IPlatoEntityMapper platoEntityMapper) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.pagingAndSortingRestauranteRepository = pagingAndSortingRestauranteRepository;
        this.restaurantePageMapper = restaurantePageMapper;
        this.platoRepository = platoRepository;
        this.platoEntityMapper = platoEntityMapper;
    }
    
    @Bean
    public IRestaurantePersistenceServicePort restaurantePersistenceServicePort() {
        return new RestauranteAdapter(restauranteRepository, pagingAndSortingRestauranteRepository, restauranteEntityMapper, restaurantePageMapper);
    }
    
    @Bean
    public IRestauranteServicePort restauranteServicePort() {
        return new RestauranteUseCase(restaurantePersistenceServicePort());
    }
    
    @Bean
    public IPlatoPersistenceServicePort platoPersistenceServicePort() {
        return new PlatoAdapter(platoRepository, platoEntityMapper);
    }
    
    @Bean
    public IPlatoServicePort platoServicePort() {
        return new PlatoUseCase(platoPersistenceServicePort());
    }
}
