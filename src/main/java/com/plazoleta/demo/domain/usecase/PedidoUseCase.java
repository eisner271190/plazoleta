/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.domain.usecase;

import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.persistence.IPedidoPersistenceServicePort;
import com.plazoleta.demo.domain.ports.IPedidoServicePort;

/**
 *
 * @author usuario
 */
public class PedidoUseCase implements IPedidoServicePort {

    private final IPedidoPersistenceServicePort pedidoPersistenceServicePort;

    public PedidoUseCase(IPedidoPersistenceServicePort pedidoPersistenceServicePort) {
        this.pedidoPersistenceServicePort = pedidoPersistenceServicePort;
    }

    @Override
    public boolean hasOrdenInProcess(int idCliente) {
        return pedidoPersistenceServicePort.validateOrdenInProcess(idCliente);
    }

    @Override
    public void savePedido(PedidoModel pedido) {
        pedidoPersistenceServicePort.savePedido(pedido);
    }
}
