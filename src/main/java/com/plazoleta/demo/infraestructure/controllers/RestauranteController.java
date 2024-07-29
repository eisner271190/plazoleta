/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.dto.RequestCreateRestauranteDTO;
import com.plazoleta.demo.application.dto.ResponseRestauranteDTO;
import com.plazoleta.demo.application.handler.IRestauranteHandler;
import com.plazoleta.demo.domain.model.RestauranteModel;
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
public class RestauranteController {

    private final IRestauranteHandler restauranteHandler;

    public RestauranteController(IRestauranteHandler restauranteHandler) {
        this.restauranteHandler = restauranteHandler;
    }

    @PostMapping("/admin/crear")
    public void crearRestaurante(@RequestBody RequestCreateRestauranteDTO restaurante) {
        restauranteHandler.createRestaurante(restaurante);
    }
    
    @GetMapping("/client/listar")
    public Page<ResponseRestauranteDTO> getRestaurants
    (
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size 
    )
    {
        return restauranteHandler.getRestaurants(page, size);
    }
}
