package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.RequestCreatePedidoDTO;

public interface IPedidoHandler {
    void createPedido(RequestCreatePedidoDTO pedido);
}
