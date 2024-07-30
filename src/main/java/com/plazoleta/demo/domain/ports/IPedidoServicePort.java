package com.plazoleta.demo.domain.ports;

import com.plazoleta.demo.application.dto.RequestSearchPedidoDTO;
import com.plazoleta.demo.domain.model.PedidoModel;
import org.springframework.data.domain.Page;

public interface IPedidoServicePort {
    boolean hasOrdenInProcess(int idCliente);
    void savePedido(PedidoModel pedido);
    Page<PedidoModel> getPedidos(RequestSearchPedidoDTO request);
}
