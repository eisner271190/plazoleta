package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.application.dto.ResponseRestauranteDTO;
import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.infraestructure.jpa.entity.RestauranteEntity;
import feign.Response;
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

    public Page<RestauranteModel> toModel(Page<ResponseRestauranteDTO> dtoPage) {
        List<RestauranteModel> models = dtoPage.getContent().stream()
                .map(restauranteMapper::toModel)
                .collect(Collectors.toList());

        return new PageImpl<>(models, dtoPage.getPageable(), dtoPage.getTotalElements());
    }

    public Page<ResponseRestauranteDTO> toDTOPage(Page<RestauranteModel> modelPage) {
        List<ResponseRestauranteDTO> dto = modelPage.getContent().stream()
                .map(restauranteMapper::toDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(dto, modelPage.getPageable(), modelPage.getTotalElements());
    }
}
