/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.plazoleta.demo.domain.ports;

import com.plazoleta.demo.domain.model.PlatoModel;

import java.util.Optional;

/**
 *
 * @author usuario
 */
public interface IPlatoServicePort
{
    PlatoModel findById(Long id);
    void savePlato(PlatoModel plato);
}
