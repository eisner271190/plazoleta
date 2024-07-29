/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.dto.*;
import com.plazoleta.demo.application.handler.IPlatoHandler;
import com.plazoleta.demo.infraestructure.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/client/listar")
    public Page<ResponsePlatoDTO> getRestaurants
            (
                    @RequestParam Long idRestaurante,
                    @RequestParam(defaultValue = "") String category,
                    @RequestParam(defaultValue = "1") int page,
                    @RequestParam(defaultValue = "10") int size
            )
    {
        var request = new RequestSearchPlatoDTO(idRestaurante, page, category, size);
        return platoHandler.getPlatos(request);
    }
}
