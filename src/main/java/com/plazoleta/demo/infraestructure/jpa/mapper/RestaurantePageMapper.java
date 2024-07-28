package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.infraestructure.jpa.entity.RestauranteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantePageMapper {

    private final IRestauranteEntityMapper restauranteMapper;

    public RestaurantePageMapper(IRestauranteEntityMapper restauranteMapper) {
        this.restauranteMapper = restauranteMapper;
    }

    public Page<RestauranteModel> toModelPage(Page<RestauranteEntity> entityPage) {
        List<RestauranteModel> models = entityPage.getContent().stream()
                .map(restauranteMapper::toModel)
                .collect(Collectors.toList());

        return new PageImpl<>(models, entityPage.getPageable(), entityPage.getTotalElements());
    }

    public Page<RestauranteEntity> toEntityPage(Page<RestauranteModel> modelPage) {
        List<RestauranteEntity> entities = modelPage.getContent().stream()
                .map(restauranteMapper::toEntity)
                .collect(Collectors.toList());

        return new PageImpl<>(entities, modelPage.getPageable(), modelPage.getTotalElements());
    }
}
