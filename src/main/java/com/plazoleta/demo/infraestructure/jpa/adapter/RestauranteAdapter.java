/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.adapter;

import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.persistence.IRestaurantePersistenceServicePort;
import com.plazoleta.demo.infraestructure.jpa.entity.RestauranteEntity;
import com.plazoleta.demo.infraestructure.jpa.mapper.IRestauranteEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.RestaurantePageMapper;
import org.springframework.data.domain.Page;
import java.util.Optional;
import com.plazoleta.demo.infraestructure.jpa.repositories.IRestauranteRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPagingAndSortingRestauranteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.plazoleta.demo.infraestructure.exception.RestauranteNotFoundException;

/**
 *
 * @author usuario
 */
public class RestauranteAdapter implements IRestaurantePersistenceServicePort {

    private final IRestauranteRepository restautanteRepository;
    private final IPagingAndSortingRestauranteRepository pagingAndSortingRestauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final RestaurantePageMapper restaurantePageMapper;

    public RestauranteAdapter(IRestauranteRepository restautanteRepository,
                              IPagingAndSortingRestauranteRepository pagingAndSortingRestauranteRepository,
                              IRestauranteEntityMapper restauranteEntityMapper,
                              RestaurantePageMapper restaurantePageMapper) {
        this.restautanteRepository = restautanteRepository;
        this.pagingAndSortingRestauranteRepository = pagingAndSortingRestauranteRepository;
        this.restauranteEntityMapper = restauranteEntityMapper;
        this.restaurantePageMapper = restaurantePageMapper;
    }

    @Override
    public RestauranteModel findById(Long id) {
        Optional<RestauranteEntity> userEntity = restautanteRepository.findById(id);
        return restauranteEntityMapper.toModel(userEntity.orElseThrow(RestauranteNotFoundException::new));
    }

    @Override
    public void saveRestaurante(RestauranteModel restaurante) {
        restautanteRepository.save(restauranteEntityMapper.toEntity(restaurante));
    }

    @Override
    public Page<RestauranteModel> getRestaurants(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return restaurantePageMapper.toModelPage(pagingAndSortingRestauranteRepository.findAll(pageable));
    }
}
