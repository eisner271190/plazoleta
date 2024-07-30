package com.plazoleta.demo.infraestructure.jpa.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class PedidoEntity {
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
	private RestauranteEntity id_restaurante;
	
	@Column
	private String nit;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<PedidoPlatoEntity> platos = new HashSet<>();

	public PedidoEntity() { }

	public PedidoEntity(Long id, int id_cliente, Date fecha, String estado, int id_chef,
					   RestauranteEntity id_restaurante, String nit, Set<PedidoPlatoEntity> platos) {
		this.id = id;
		this.id_cliente = id_cliente;
		this.fecha = fecha;
		this.estado = estado;
		this.id_chef = id_chef;
		this.id_restaurante = id_restaurante;
		this.nit = nit;
		this.platos = platos;
	}

	// Getters y Setters
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

	public RestauranteEntity getId_restaurante() {
		return id_restaurante;
	}

	public void setId_restaurante(RestauranteEntity id_restaurante) {
		this.id_restaurante = id_restaurante;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Set<PedidoPlatoEntity> getPlatos() { return platos; }

	public void setPlatos(Set<PedidoPlatoEntity> platos) { this.platos = platos; }
}
