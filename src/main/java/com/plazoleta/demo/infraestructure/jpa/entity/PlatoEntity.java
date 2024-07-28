package com.plazoleta.demo.infraestructure.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "plato")

public class PlatoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{validation.dish.name.required}")
    @Column(nullable = false)
	private String nombre;
	
    @Min(value = 1, message = "{validation.dish.price.invalid}")
	@Column(nullable = false)
	private int precio;
        
    @NotBlank(message = "{validation.description.requerid}")
    @Column(nullable = false)
    private String descripcion;

    @NotBlank(message = "{validation.urlimage.requerid}")
    @Column(nullable = false)
    private String urlImage;

    @NotBlank(message = "{validation.category.requerid}")
    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private boolean active;

    @NotNull(message = "{validation.idresturante.requerid}")
    @Column(nullable = false)
    private Long restaurantId;

    public PlatoEntity() {
    }

    // Constructor con parámetros
    public PlatoEntity(Long id, String nombre, int precio, String descripcion,
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
