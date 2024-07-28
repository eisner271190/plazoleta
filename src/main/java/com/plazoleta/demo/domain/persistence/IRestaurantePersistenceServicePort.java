/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.plazoleta.demo.domain.persistence;

import com.plazoleta.demo.domain.model.RestauranteModel;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 *
 * @author usuario
 */
public interface IRestaurantePersistenceServicePort
{
    RestauranteModel findById(Long id);
    void saveRestaurante(RestauranteModel model);
    Page<RestauranteModel> getRestaurants(int page, int size);
}
