/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.repositories;

import com.plazoleta.demo.infraestructure.jpa.entity.PedidoEntity;
import com.plazoleta.demo.infraestructure.jpa.entity.RestauranteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IPagingAndSortingPedidoRepository extends PagingAndSortingRepository<PedidoEntity, Long> {
    Page<PedidoEntity> findByEstadoAndRestaurante(String estado, RestauranteEntity restaurante, Pageable pageable);
}
