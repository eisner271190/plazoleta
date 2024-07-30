/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.controllers;

import com.plazoleta.demo.application.dto.RequestCreatePedidoDTO;
import com.plazoleta.demo.application.handler.IPedidoHandler;
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
}
