/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.plazoleta.demo.domain.persistence;

import com.plazoleta.demo.application.dto.RequestSearchPlatoDTO;
import com.plazoleta.demo.domain.model.PlatoModel;
import org.springframework.data.domain.Page;

/**
 *
 * @author usuario
 */
public interface IPlatoPersistenceServicePort
{
    PlatoModel findById(Long id);
    void savePlato(PlatoModel plato);
    Page<PlatoModel> getPlatos(RequestSearchPlatoDTO request);
}
