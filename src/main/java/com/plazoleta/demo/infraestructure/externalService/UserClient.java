/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.infraestructure.externalService;

import com.plazoleta.demo.infraestructure.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userService", url = "http://localhost:8082", configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping(value = "/api/v1/users/owner/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean getOwnerById(@PathVariable("id") Long id);
}
