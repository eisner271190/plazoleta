package com.plazoleta.demo.domain.ports;

import com.plazoleta.demo.domain.model.PedidoModel;

public interface IPedidoServicePort {
    boolean hasOrdenInProcess(int idCliente);
    void savePedido(PedidoModel pedido);

}
