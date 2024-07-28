/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.dto;


/**
 *
 * @author usuario
 */
public class ActivePlatoDTO {
 
    private Long id;
    private Boolean valor;
    private Long id_propietario;

    public Long getId() {
        return id;
    }

    // Setter para id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para valor
    public Boolean getValor() {
        return valor;
    }

    // Setter para valor
    public void setValor(Boolean valor) {
        this.valor = valor;
    }

    public Long getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(Long id_propietario) {
        this.id_propietario = id_propietario;
    }
}
