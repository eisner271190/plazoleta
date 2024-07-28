package com.plazoleta.demo.infraestructure.jpa.entity;

import com.plazoleta.demo.domain.constants.RestaurantConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurante")
public class RestauranteEntity {
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

    public RestauranteEntity() {
    }

    // Constructor con parámetros
    public RestauranteEntity(Long id, String nombre, String nit, String direccion,
                            String telefono, String urlLogo, Long id_propietario) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.urlLogo = urlLogo;
        this.id_propietario = id_propietario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public Long getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(Long id_propietario) {
        this.id_propietario = id_propietario;
    }
}