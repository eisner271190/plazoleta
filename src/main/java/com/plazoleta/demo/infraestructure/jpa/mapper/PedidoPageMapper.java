package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.infraestructure.jpa.entity.PedidoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoPageMapper {

    private final IPedidoEntityMapper pedidoEntityMapper;

    public PedidoPageMapper(IPedidoEntityMapper pedidoEntityMapper) {
        this.pedidoEntityMapper = pedidoEntityMapper;
    }

    public Page<PedidoModel> toModelPage(Page<PedidoEntity> entityPage) {
        var models = entityPage.getContent().stream()
                .map(pedidoEntityMapper::toModel)
                .collect(Collectors.toList());

        return new PageImpl<>(models, entityPage.getPageable(), entityPage.getTotalElements());
    }

    public Page<PedidoEntity> toEntityPage(Page<PedidoModel> modelPage) {
        var entities = modelPage.getContent().stream()
                .map(pedidoEntityMapper::toEntity)
                .collect(Collectors.toList());

        return new PageImpl<>(entities, modelPage.getPageable(), modelPage.getTotalElements());
    }
}
