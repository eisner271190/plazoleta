/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.RequestCreatePedidoDTO;
import com.plazoleta.demo.application.dto.RequestSearchPedidoDTO;
import com.plazoleta.demo.application.mapper.IPedidoMapper;
import com.plazoleta.demo.application.mapper.IRestauranteMapper;
import com.plazoleta.demo.domain.constants.EstadosConstants;
import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.ports.IPedidoServicePort;
import com.plazoleta.demo.infraestructure.exception.ClientWithOrdenInProcessException;
import com.plazoleta.demo.infraestructure.jpa.mapper.PedidoPageMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @author usuario
 */
@Service
public class PedidoHandler implements IPedidoHandler {
    private final IPedidoServicePort pedidoServicePort;
    private final IPedidoMapper pedidoMapper;
    private final PedidoPageMapper pedidoPageMapper;

    public PedidoHandler(IPedidoServicePort pedidoServicePort,
                         IPedidoMapper pedidoMapper,
                         PedidoPageMapper pedidoPageMapper) {
        this.pedidoServicePort = pedidoServicePort;
        this.pedidoMapper = pedidoMapper;
        this.pedidoPageMapper = pedidoPageMapper;
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

    @Override
    public Page<PedidoModel> getPedidos(RequestSearchPedidoDTO request)
    {
        return pedidoServicePort.getPedidos(request);
    }
}
