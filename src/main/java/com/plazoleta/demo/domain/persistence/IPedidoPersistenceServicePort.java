package com.plazoleta.demo.domain.persistence;

import com.plazoleta.demo.application.dto.RequestSearchPedidoDTO;
import com.plazoleta.demo.domain.model.PedidoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

public interface IPedidoPersistenceServicePort {
    boolean validateOrdenInProcess(int idCliente);
    @Transactional
    void savePedido(PedidoModel pedido);
    Page<PedidoModel> getPedidos(RequestSearchPedidoDTO request);
}
