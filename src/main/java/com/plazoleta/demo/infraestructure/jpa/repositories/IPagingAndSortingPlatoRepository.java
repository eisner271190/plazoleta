/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.repositories;

import com.plazoleta.demo.infraestructure.jpa.entity.PlatoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IPagingAndSortingPlatoRepository extends PagingAndSortingRepository<PlatoEntity, Long> {
    Page<PlatoEntity> findByCategoryAndRestaurantId(String category, Long restaurantId, Pageable pageable);
    Page<PlatoEntity> findByCategory(String category, Pageable pageable);
    Page<PlatoEntity> findByRestaurantId(Long restaurantId, Pageable pageable);
}
