/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.jpa.adapter;

import com.plazoleta.demo.application.dto.RequestSearchPedidoDTO;
import com.plazoleta.demo.domain.constants.EstadosConstants;
import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.persistence.IPedidoPersistenceServicePort;
import com.plazoleta.demo.infraestructure.exception.RestauranteNotFoundException;
import com.plazoleta.demo.infraestructure.jpa.mapper.IPedidoEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.PedidoPageMapper;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPagingAndSortingPedidoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPedidoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IRestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class PedidoAdapter implements IPedidoPersistenceServicePort {

    private final IPedidoRepository pedidoRepository;
    private final IRestauranteRepository restauranteRepository;
    private final IPagingAndSortingPedidoRepository pagingAndSortingPedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;
    private final PedidoPageMapper pedidoPageMapper;

    public PedidoAdapter(IPedidoRepository pedidoRepository,
                         IRestauranteRepository restauranteRepository,
                         IPagingAndSortingPedidoRepository pagingAndSortingPedidoRepository,
                         IPedidoEntityMapper pedidoEntityMapper,
                         PedidoPageMapper pedidoPageMapper) {
        this.pedidoRepository = pedidoRepository;
        this.restauranteRepository = restauranteRepository;
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

        var restaurante = restauranteRepository.findById(pedido.getRestaurante().getId());

        if(restaurante.isEmpty())
        {
            throw new RestauranteNotFoundException();
        }

        for (var plato : entity.getPlatos()) {
            plato.setPedido(entity);
        }

        pedidoRepository.save(entity);
    }

    @Override
    public Page<PedidoModel> getPedidos(RequestSearchPedidoDTO request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        var restaurante = restauranteRepository.findById(request.getIdRestaurante());

        if(restaurante.isEmpty()) throw new RestauranteNotFoundException();

        var result = pagingAndSortingPedidoRepository.findByEstadoAndRestaurante(request.getEstado(), restaurante.get(), pageable);

        return pedidoPageMapper.toModelPage(result);
    }
}
