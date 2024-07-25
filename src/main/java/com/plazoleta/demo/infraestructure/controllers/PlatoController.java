/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.services.PlatoService;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.infraestructure.dto.request.ActivePlatoModel;
import com.plazoleta.demo.infraestructure.dto.request.UpdatePlatoModel;
import com.plazoleta.demo.infraestructure.security.JwtService;
import com.plazoleta.demo.infraestructure.security.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class PlatoController {

    private final PlatoService platoService;
    private final JwtService jwtService;

    @PostMapping("/owner/crear")
    public void crearPlato(@RequestParam Long ownerId, @RequestBody @Valid PlatoModel plato) {
        platoService.createPlato(ownerId, plato);
    }
    
    @PostMapping("/owner/modificar")
    public void updatePlato(@RequestBody UpdatePlatoModel plato) {
        platoService.updatePlato(plato);
    }
    
    @PostMapping("/owner/activar")
    public void activePlato(@RequestBody ActivePlatoModel plato, HttpServletRequest request) {
        Long id = Long.valueOf(jwtService.getClaim(request, "id_propietario"));
        plato.setId_propietario(id);
        platoService.activePlato(plato);
    }
}
