package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.domain.model.PedidoPlatoModel;
import com.plazoleta.demo.infraestructure.jpa.entity.PedidoPlatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoPlatoEntityMapper {
    PedidoPlatoModel toModel(PedidoPlatoEntity entity);

    @Mapping(target = "pedido", ignore = true)
    PedidoPlatoEntity toEntity(PedidoPlatoModel model);

    List<PedidoPlatoModel> toModelList(List<PedidoPlatoEntity> entity);
    List<PedidoPlatoEntity> toEntityList(List<PedidoPlatoModel> model);
}
