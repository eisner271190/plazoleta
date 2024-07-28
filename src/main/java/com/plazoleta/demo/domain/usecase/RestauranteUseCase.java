/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.domain.usecase;

import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.domain.persistence.IRestaurantePersistenceServicePort;
import com.plazoleta.demo.domain.ports.IRestauranteServicePort;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 *
 * @author usuario
 */
public class RestauranteUseCase implements IRestauranteServicePort {

    private final IRestaurantePersistenceServicePort restaurantePersistenceServicePort;

    public RestauranteUseCase(IRestaurantePersistenceServicePort restaurantePersistenceServicePort) {
        this.restaurantePersistenceServicePort = restaurantePersistenceServicePort;
    }

    @Override
    public RestauranteModel findById(Long id) {
        return restaurantePersistenceServicePort.findById(id);
    }

    @Override
    public void saveRestaurante(RestauranteModel restaurante) {
        restaurantePersistenceServicePort.saveRestaurante(restaurante);
    }

    @Override
    public Page<RestauranteModel> getRestaurants(int page, int size) {
        return restaurantePersistenceServicePort.getRestaurants(page, size);
    }
}
