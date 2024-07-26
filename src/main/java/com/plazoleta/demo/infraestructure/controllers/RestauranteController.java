/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.services.RestauranteService;
import com.plazoleta.demo.domain.model.RestauranteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/api/v1/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteService restauranteService;

    @PostMapping("/admin/crear")
    public void crearRestaurante(@RequestBody RestauranteModel restaurante) {
        restauranteService.createRestaurante(restaurante);
    }
    
    @GetMapping("/owner/listar")
    public Page<RestauranteModel> getRestaurants
    (
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size 
    )
    {
        return restauranteService.getRestaurants(page, size);
    }
}
