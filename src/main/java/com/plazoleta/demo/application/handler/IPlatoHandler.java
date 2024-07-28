package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.ActivePlatoDTO;
import com.plazoleta.demo.application.dto.RequestCreatePlatoDTO;
import com.plazoleta.demo.application.dto.UpdatePlatoDTO;

public interface IPlatoHandler {

    void createPlato(RequestCreatePlatoDTO plato);
    void updatePlato(UpdatePlatoDTO update);
    void activePlato(ActivePlatoDTO update);
}
