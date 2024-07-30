/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.adapter;

import com.plazoleta.demo.domain.constants.EstadosConstants;
import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.persistence.IPedidoPersistenceServicePort;
import com.plazoleta.demo.infraestructure.jpa.entity.PedidoEntity;
import com.plazoleta.demo.infraestructure.jpa.entity.PedidoPlatoEntity;
import com.plazoleta.demo.infraestructure.jpa.entity.PlatoEntity;
import com.plazoleta.demo.infraestructure.jpa.entity.RestauranteEntity;
import com.plazoleta.demo.infraestructure.jpa.mapper.IPedidoEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.PedidoPageMapper;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPagingAndSortingPedidoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPedidoRepository;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class PedidoAdapter implements IPedidoPersistenceServicePort {

    private final IPedidoRepository pedidoRepository;
    private final IPagingAndSortingPedidoRepository pagingAndSortingPedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;
    private final PedidoPageMapper pedidoPageMapper;

    public PedidoAdapter(IPedidoRepository pedidoRepository,
                         IPagingAndSortingPedidoRepository pagingAndSortingPedidoRepository,
                         IPedidoEntityMapper pedidoEntityMapper,
                         PedidoPageMapper pedidoPageMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pagingAndSortingPedidoRepository = pagingAndSortingPedidoRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
        this.pedidoPageMapper = pedidoPageMapper;
    }

    @Override
    public boolean validateOrdenInProcess(int idCliente) {
        List<String> estados = new ArrayList<>();
        estados.add(EstadosConstants.PENDING);
        estados.add(EstadosConstants.READY);
        estados.add(EstadosConstants.INPROGRESS);

        var pedidos = pedidoRepository.findByClienteAndEstado(idCliente, estados);

        return !pedidos.isEmpty();
    }

    @Override
    @Transactional
    public void savePedido(PedidoModel pedido) {
        var entity = pedidoEntityMapper.toEntity(pedido);

        for (var plato : entity.getPlatos()) {
            plato.setPedido(entity);
        }

        pedidoRepository.save(entity);
    }

//    @Override
//    public Page<PedidoModel> getPedidos(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return pedidoPageMapper.toModelPage(pagingAndSortingPedidoRepository.findAll(pageable));
//    }
}
