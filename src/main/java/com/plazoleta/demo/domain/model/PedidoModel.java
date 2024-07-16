package com.plazoleta.demo.domain.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class PedidoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int id_cliente;
	
	@Column
	private Date fecha;
	
	@Column
	private String estado;
	
	@Column
	private int id_chef;
	
	@ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteModel id_restaurante;
	
	@Column
	private String nit;
}
