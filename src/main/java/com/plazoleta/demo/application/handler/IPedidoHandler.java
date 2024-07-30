package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.RequestCreatePedidoDTO;
import com.plazoleta.demo.application.dto.RequestSearchPedidoDTO;
import com.plazoleta.demo.domain.model.PedidoModel;
import org.springframework.data.domain.Page;

public interface IPedidoHandler {
    void createPedido(RequestCreatePedidoDTO pedido);
    Page<PedidoModel> getPedidos(RequestSearchPedidoDTO request);
}
