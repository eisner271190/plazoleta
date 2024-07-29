package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.*;
import org.springframework.data.domain.Page;

public interface IPlatoHandler {

    void createPlato(RequestCreatePlatoDTO plato);
    void updatePlato(UpdatePlatoDTO update);
    void activePlato(ActivePlatoDTO update);
    Page<ResponsePlatoDTO> getPlatos(RequestSearchPlatoDTO request);
}
