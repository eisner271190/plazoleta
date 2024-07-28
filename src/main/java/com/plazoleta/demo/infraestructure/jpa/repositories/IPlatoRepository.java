/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.repositories;

import com.plazoleta.demo.infraestructure.jpa.entity.PlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface IPlatoRepository extends JpaRepository<PlatoEntity, Long> {
}
