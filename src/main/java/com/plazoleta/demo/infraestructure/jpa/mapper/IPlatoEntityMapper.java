package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.application.dto.ResponsePlatoDTO;
import com.plazoleta.demo.domain.model.PlatoModel;
import com.plazoleta.demo.infraestructure.jpa.entity.PlatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlatoEntityMapper {
    PlatoModel toModel(PlatoEntity entity);
    PlatoEntity toEntity(PlatoModel model);

    PlatoModel toModel(ResponsePlatoDTO dto);
    ResponsePlatoDTO toDTO(PlatoModel model);
}
