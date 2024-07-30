package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.application.dto.ResponsePlatoDTO;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.infraestructure.jpa.entity.PlatoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlatoPageMapper {

    private final IPlatoEntityMapper platoMapper;

    public PlatoPageMapper(IPlatoEntityMapper platoMapper) {
        this.platoMapper = platoMapper;
    }

    public Page<PlatoModel> toModelPage(Page<PlatoEntity> entityPage) {
        List<PlatoModel> models = entityPage.getContent().stream()
                .map(platoMapper::toModel)
                .collect(Collectors.toList());

        return new PageImpl<>(models, entityPage.getPageable(), entityPage.getTotalElements());
    }

    public Page<PlatoEntity> toEntityPage(Page<PlatoModel> modelPage) {
        List<PlatoEntity> entities = modelPage.getContent().stream()
                .map(platoMapper::toEntity)
                .collect(Collectors.toList());

        return new PageImpl<>(entities, modelPage.getPageable(), modelPage.getTotalElements());
    }

    public Page<PlatoModel> toModel(Page<ResponsePlatoDTO> dtoPage) {
        List<PlatoModel> models = dtoPage.getContent().stream()
                .map(platoMapper::toModel)
                .collect(Collectors.toList());

        return new PageImpl<>(models, dtoPage.getPageable(), dtoPage.getTotalElements());
    }

    public Page<ResponsePlatoDTO> toDTOPage(Page<PlatoModel> modelPage) {
        List<ResponsePlatoDTO> dto = modelPage.getContent().stream()
                .map(platoMapper::toDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(dto, modelPage.getPageable(), modelPage.getTotalElements());
    }
}
