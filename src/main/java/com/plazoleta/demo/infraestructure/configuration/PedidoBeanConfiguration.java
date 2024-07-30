/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.configuration;

import com.plazoleta.demo.domain.persistence.IPedidoPersistenceServicePort;
import com.plazoleta.demo.domain.ports.IPedidoServicePort;
import com.plazoleta.demo.domain.usecase.PedidoUseCase;
import com.plazoleta.demo.infraestructure.jpa.adapter.PedidoAdapter;
import com.plazoleta.demo.infraestructure.jpa.mapper.IPedidoEntityMapper;
import com.plazoleta.demo.infraestructure.jpa.mapper.PedidoPageMapper;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPagingAndSortingPedidoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IPedidoRepository;
import com.plazoleta.demo.infraestructure.jpa.repositories.IRestauranteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author usuario
 */
@Configuration
public class PedidoBeanConfiguration {

    private final IPedidoRepository pedidoRepository;
    private final IRestauranteRepository restauranteRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;
    private final IPagingAndSortingPedidoRepository pagingAndSortingPedidoRepository;
    private final PedidoPageMapper pedidoPageMapper;

    public PedidoBeanConfiguration(IPedidoRepository pedidoRepository,
                                   IRestauranteRepository restauranteRepository,
                                   IPedidoEntityMapper pedidoEntityMapper,
                                   IPagingAndSortingPedidoRepository pagingAndSortingPedidoRepository,
                                   PedidoPageMapper pedidoPageMapper) {
        this.pedidoRepository = pedidoRepository;
        this.restauranteRepository = restauranteRepository;
        this.pedidoEntityMapper = pedidoEntityMapper;
        this.pagingAndSortingPedidoRepository = pagingAndSortingPedidoRepository;
        this.pedidoPageMapper = pedidoPageMapper;
    }
    
    @Bean
    public IPedidoPersistenceServicePort pedidoPersistenceServicePort() {
        return new PedidoAdapter(pedidoRepository, restauranteRepository, pagingAndSortingPedidoRepository, pedidoEntityMapper, pedidoPageMapper);
    }
    
    @Bean
    public IPedidoServicePort pedidoServicePort() {
        return new PedidoUseCase(pedidoPersistenceServicePort());
    }
}
