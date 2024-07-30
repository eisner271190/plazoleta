package com.plazoleta.demo.application.dto;

import com.plazoleta.demo.domain.model.PedidoModel;
import com.plazoleta.demo.domain.model.PlatoModel;

public class PedidoPlatoDTO {
	private Long id;
	private RequestCreatePedidoDTO pedido;
	private PlatoModel plato;
	private int cantidad;

	public PedidoPlatoDTO() {}

	public PedidoPlatoDTO(Long id, RequestCreatePedidoDTO pedido, PlatoModel plato, int cantidad) {
		this.id = id;
		this.pedido = pedido;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public RequestCreatePedidoDTO getPedido() { return pedido; }

	public void setPedido(RequestCreatePedidoDTO pedido) {
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
