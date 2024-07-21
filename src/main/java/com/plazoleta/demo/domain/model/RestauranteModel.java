package com.plazoleta.demo.domain.model;

import com.plazoleta.demo.domain.constants.RestaurantConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurante")
public class RestauranteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{validation.restaurant.name.required}")
    //@Pattern(regexp = RestaurantConstants.NOMBRE_REGEX, message = "{validation.restaurant.name.invalid}")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "{validation.restaurant.nit.required}")
    @Pattern(regexp = RestaurantConstants.NIT_REGEX, message = "{validation.restaurant.nit.numeric}")
    @Column(nullable = false)
    private String nit;

    @NotBlank(message = "{validation.restaurant.direccion.required}")
    @Column(nullable = false)
    private String direccion;

    @NotBlank(message = "{validation.restaurant.telefono.required}")
    @Pattern(regexp = RestaurantConstants.TELEFONO_REGEX, message = "{validation.restaurant.telefono.invalid}")
    @Column(nullable = false)
    private String telefono;

    @NotBlank(message = "{validation.restaurant.urlLogo.required}")
    @Column(nullable = false)
    private String urlLogo;
    
    @NotNull(message = "{validation.restaurant.id_propietario.required}")
    @Column(nullable = false)
    private Long id_propietario;
}