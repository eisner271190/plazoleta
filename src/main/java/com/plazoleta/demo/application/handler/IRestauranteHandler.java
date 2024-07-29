package com.plazoleta.demo.application.handler;

import com.plazoleta.demo.application.dto.RequestCreateRestauranteDTO;
import com.plazoleta.demo.application.dto.ResponseRestauranteDTO;
import org.springframework.data.domain.Page;

public interface IRestauranteHandler {

    void createRestaurante(RequestCreateRestauranteDTO restaurante);
    Page<ResponseRestauranteDTO> getRestaurants(int page, int size);
}
