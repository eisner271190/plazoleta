/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.RequestCreatePedidoDTO;
import com.plazoleta.demo.application.mapper.IPedidoMapper;
import com.plazoleta.demo.domain.constants.EstadosConstants;
import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.ports.IPedidoServicePort;
import com.plazoleta.demo.infraestructure.exception.ClientWithOrdenInProcessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author usuario
 */
@Service
public class PedidoHandler implements IPedidoHandler {
    private final IPedidoServicePort pedidoServicePort;
    private final IPedidoMapper pedidoMapper;

    public PedidoHandler(IPedidoServicePort pedidoServicePort,
                         IPedidoMapper pedidoMapper) {
        this.pedidoServicePort = pedidoServicePort;
        this.pedidoMapper = pedidoMapper;
    }
    
    @Override
    public void createPedido(RequestCreatePedidoDTO pedidoDto) {
        PedidoModel pedido = pedidoMapper.toModel(pedidoDto);
        pedido.setEstado(EstadosConstants.PENDING);
        pedido.setFecha(new Date());

        if(pedidoServicePort.hasOrdenInProcess(pedido.getId_cliente()))
        {
            throw new ClientWithOrdenInProcessException();
        }

        pedidoServicePort.savePedido(pedido);
    }
}
