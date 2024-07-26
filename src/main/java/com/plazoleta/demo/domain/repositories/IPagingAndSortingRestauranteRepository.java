/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.domain.repositories;

import com.plazoleta.demo.domain.model.RestauranteModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IPagingAndSortingRestauranteRepository extends PagingAndSortingRepository<RestauranteModel, Long> {
}
