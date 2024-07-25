/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.externalService;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        // Aquí debes obtener el token de alguna manera, por ejemplo desde el contexto de seguridad
        String token = "your_token_here"; // Reemplaza esto con la lógica para obtener el token real
        template.header("Authorization", "Bearer " + token);
    }
}
