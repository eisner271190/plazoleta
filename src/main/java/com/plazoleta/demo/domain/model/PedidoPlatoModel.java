package com.plazoleta.demo.domain.model;

public class PedidoPlatoModel {
	private Long id;
	private PedidoModel pedido;
	private PlatoModel plato;
	private int cantidad;

	public PedidoPlatoModel() {}

	public PedidoPlatoModel(Long id, PedidoModel pedido, PlatoModel plato, int cantidad) {
		this.id = id;
		this.pedido = pedido;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public PedidoModel getPedido() { return pedido; }

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}

	public PlatoModel getPlato() { return plato; }

	public void setPlato(PlatoModel plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
