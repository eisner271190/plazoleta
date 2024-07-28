package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.domain.model.RestauranteModel;
import com.plazoleta.demo.infraestructure.jpa.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestauranteEntityMapper {
    RestauranteModel toModel(RestauranteEntity entity);
    RestauranteEntity toEntity(RestauranteModel model);
//    Page<RestauranteModel> toModel(Page<RestauranteEntity> entity);
//    Page<RestauranteEntity> toEntity(Page<RestauranteModel> model);
}
