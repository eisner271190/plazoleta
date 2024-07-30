package com.plazoleta.demo.application.dto;

public class RequestSearchPedidoDTO {
    private Long idRestaurante;
    private String estado;
    private int page;
    private int size;

    public RequestSearchPedidoDTO(Long idRestaurante, String estado, int page, int size) {
        this.idRestaurante = idRestaurante;
        this.estado = estado;
        this.page = page;
        this.size = size;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
