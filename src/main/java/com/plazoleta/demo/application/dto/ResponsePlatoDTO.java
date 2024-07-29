package com.plazoleta.demo.application.dto;

public class ResponsePlatoDTO {
	private Long id;
	private String nombre;
	private int precio;
    private String descripcion;
    private String urlImage;
    private String category;
    private boolean active;
    private Long restaurantId;

    public ResponsePlatoDTO() {
    }

    // Constructor con parámetros
    public ResponsePlatoDTO(Long id, String nombre, int precio, String descripcion,
                            String urlImage, String category, boolean active, Long restaurantId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlImage = urlImage;
        this.category = category;
        this.active = active;
        this.restaurantId = restaurantId;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
