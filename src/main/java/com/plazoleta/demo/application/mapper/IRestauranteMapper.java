package com.plazoleta.demo.application.mapper;

import com.plazoleta.demo.application.dto.RequestCreateRestauranteDTO;
import com.plazoleta.demo.domain.model.RestauranteModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestauranteMapper {
    RestauranteModel toModel(RequestCreateRestauranteDTO dto);
    RequestCreateRestauranteDTO toDTO(RestauranteModel model);
}
