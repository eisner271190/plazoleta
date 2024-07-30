package com.plazoleta.demo.infraestructure.jpa.mapper;

import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.model.PedidoPlatoModel;
import com.plazoleta.demo.infraestructure.jpa.entity.PedidoEntity;
import com.plazoleta.demo.infraestructure.jpa.entity.PedidoPlatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoEntityMapper {
    PedidoModel toModel(PedidoEntity entity);
    PedidoEntity toEntity(PedidoModel model);

    List<PedidoModel> toModelList(List<PedidoEntity> entity);
    List<PedidoEntity> toEntityList(List<PedidoModel> model);

    PedidoPlatoModel toModel(PedidoPlatoEntity entity);
    PedidoPlatoEntity toEntity(PedidoPlatoModel model);

    List<PedidoPlatoModel> toModelListItems(List<PedidoPlatoEntity> entity);
    List<PedidoPlatoEntity> toEntityListItems(List<PedidoPlatoModel> model);
}
