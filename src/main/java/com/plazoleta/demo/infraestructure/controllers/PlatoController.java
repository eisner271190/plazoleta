/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.dto.RequestCreatePlatoDTO;
import com.plazoleta.demo.application.handler.IPlatoHandler;
import com.plazoleta.demo.application.dto.ActivePlatoDTO;
import com.plazoleta.demo.application.dto.UpdatePlatoDTO;
import com.plazoleta.demo.infraestructure.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/api/v1/platos")
public class PlatoController {

    private final IPlatoHandler platoHandler;
    private final JwtService jwtService;

    public PlatoController(IPlatoHandler platoHandler, JwtService jwtService) {
        this.platoHandler = platoHandler;
        this.jwtService = jwtService;
    }

    @PostMapping("/owner/crear")
    public void crearPlato(@RequestBody @Valid RequestCreatePlatoDTO plato, HttpServletRequest request ) {
        Long id = Long.valueOf(jwtService.getClaim(request, "id_propietario"));
        plato.setOwnerId(id);
        platoHandler.createPlato(plato);
    }
    
    @PostMapping("/owner/modificar")
    public void updatePlato(@RequestBody UpdatePlatoDTO plato, HttpServletRequest request) {
        Long id = Long.valueOf(jwtService.getClaim(request, "id_propietario"));
        plato.setOwnerId(id);
        platoHandler.updatePlato(plato);
    }
    
    @PostMapping("/owner/activar")
    public void activePlato(@RequestBody ActivePlatoDTO plato, HttpServletRequest request) {
        Long id = Long.valueOf(jwtService.getClaim(request, "id_propietario"));
        plato.setId_propietario(id);
        platoHandler.activePlato(plato);
    }
}
