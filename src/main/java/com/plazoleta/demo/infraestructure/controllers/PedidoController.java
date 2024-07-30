/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.dto.*;
import com.plazoleta.demo.application.handler.IPedidoHandler;
import com.plazoleta.demo.domain.model.PedidoModel;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    private final IPedidoHandler pedidoHandler;

    public PedidoController(IPedidoHandler pedidoHandler) {
        this.pedidoHandler = pedidoHandler;
    }

    @PostMapping("/client/crear")
    public void crearPedido(@RequestBody RequestCreatePedidoDTO pedido) {
        pedidoHandler.createPedido(pedido);
    }

    @GetMapping("/employee/listar")
    public Page<PedidoModel> getPedidos
    (
            @RequestParam Long idRestaurante,
            @RequestParam(defaultValue = "") String estado,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    )
    {
        var request = new RequestSearchPedidoDTO(idRestaurante, estado, page, size);
        return pedidoHandler.getPedidos(request);
    }
}
