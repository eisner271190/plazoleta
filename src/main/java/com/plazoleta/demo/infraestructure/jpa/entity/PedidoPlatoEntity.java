package com.plazoleta.demo.infraestructure.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidoplato")
public class PedidoPlatoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
	private PedidoEntity pedido;

	@ManyToOne
	@JoinColumn(name = "plato_id", nullable = false)
	private PlatoEntity plato;

	@Column(nullable = false)
	private int cantidad;

	public PedidoPlatoEntity() {}

	public PedidoPlatoEntity(Long id, PedidoEntity id_pedido, PlatoEntity plato, int cantidad) {
		this.id = id;
		this.pedido = id_pedido;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public PedidoEntity getPedido() { return pedido; }

	public void setPedido(PedidoEntity pedido) { this.pedido = pedido; }

	public PlatoEntity getPlato() { return plato; }

	public void setPlato(PlatoEntity plato) { this.plato = plato; }

	public int getCantidad() { return cantidad; }

	public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
