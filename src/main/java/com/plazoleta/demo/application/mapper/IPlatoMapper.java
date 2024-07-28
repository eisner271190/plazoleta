package com.plazoleta.demo.application.mapper;

import com.plazoleta.demo.application.dto.RequestCreatePlatoDTO;
import com.plazoleta.demo.domain.model.PlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlatoMapper {
    PlatoModel toModel(RequestCreatePlatoDTO dto);
    RequestCreatePlatoDTO toDTO(PlatoModel model);
}
