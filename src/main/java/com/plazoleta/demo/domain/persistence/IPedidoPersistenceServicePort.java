package com.plazoleta.demo.domain.persistence;

import com.plazoleta.demo.domain.model.PedidoModel;
import jakarta.transaction.Transactional;

public interface IPedidoPersistenceServicePort {
    boolean validateOrdenInProcess(int idCliente);
    @Transactional
    void savePedido(PedidoModel pedido);
}
