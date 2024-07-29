/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plazoleta.demo.application.dto;

/**
 *
 * @author usuario
 */
public class RequestSearchPlatoDTO {

    private Long idRestaurante;
    private int page;
    private String category;
    private int size;

    public RequestSearchPlatoDTO() {
    }

    // Constructor con todos los parámetros
    public RequestSearchPlatoDTO(Long idRestaurante, int page, String category, int size) {
        this.idRestaurante = idRestaurante;
        this.page = page;
        this.category = category;
        this.size = size;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}