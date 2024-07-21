/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.services.PlatoService;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.infraestructure.dto.request.UpdatePlatoModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @PostMapping("/crear")
    public void crearPlato(@RequestParam Long ownerId, @RequestBody @Valid PlatoModel plato) {
        platoService.createPlato(ownerId, plato);
    }
    
    @PostMapping("/modificar")
    public void updatePlato(@RequestBody UpdatePlatoModel plato) {
        platoService.updatePlato(plato);
    }
}
