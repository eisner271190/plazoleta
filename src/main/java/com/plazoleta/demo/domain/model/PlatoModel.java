package com.plazoleta.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "plato")

public class PlatoModel {
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
}
