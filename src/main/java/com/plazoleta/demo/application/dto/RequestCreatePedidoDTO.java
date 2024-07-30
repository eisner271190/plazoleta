/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.dto;

import com.plazoleta.demo.domain.model.PedidoPlatoModel;
import com.plazoleta.demo.domain.model.RestauranteModel;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class RequestCreatePedidoDTO {
    private Long id;
    private int id_cliente;
    private Date fecha;
    private String estado;
    private int id_chef;
    private RequestRestauranteDTO restaurante;
    private Set<PedidoPlatoModel> platos;

    public RequestCreatePedidoDTO(Long id, int id_cliente, Date fecha, String estado, int id_chef, RequestRestauranteDTO restaurante, Set<PedidoPlatoModel> platos) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.estado = estado;
        this.id_chef = id_chef;
        this.restaurante = restaurante;
        this.platos = platos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_chef() {
        return id_chef;
    }

    public void setId_chef(int id_chef) {
        this.id_chef = id_chef;
    }

    public RequestRestauranteDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RequestRestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    public Set<PedidoPlatoModel> getPlatos() {
        return platos;
    }

    public void setPlatos(Set<PedidoPlatoModel> platos) {
        this.platos = platos;
    }
}