/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.dto.request;

import lombok.Data;

/**
 *
 * @author usuario
 */
@Data
public class UpdatePlatoModel {
 
    private Long id;
    private String descripcion;
    private int precio;
}
