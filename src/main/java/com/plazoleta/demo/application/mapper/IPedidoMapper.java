package com.plazoleta.demo.application.mapper;

import com.plazoleta.demo.application.dto.PedidoPlatoDTO;
import com.plazoleta.demo.application.dto.RequestCreatePedidoDTO;
import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.model.PedidoPlatoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoMapper {
    PedidoModel toModel(RequestCreatePedidoDTO dto);
    RequestCreatePedidoDTO toDTO(PedidoModel model);

    PedidoPlatoModel toModel(PedidoPlatoDTO dto);
    PedidoPlatoDTO toDTO(PedidoPlatoModel model);
}
