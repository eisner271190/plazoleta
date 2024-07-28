package com.plazoleta.demo.domain.model;

import java.util.Date;

public class PedidoModel {
		private Long id;
		private int id_cliente;
		private Date fecha;
		private String estado;
		private int id_chef;
		private RestauranteModel id_restaurante;
		private String nit;

		// Constructor vacío
		public PedidoModel() {
		}

		// Constructor con parámetros
		public PedidoModel(Long id, int id_cliente, Date fecha, String estado, int id_chef,
						   RestauranteModel id_restaurante, String nit) {
			this.id = id;
			this.id_cliente = id_cliente;
			this.fecha = fecha;
			this.estado = estado;
			this.id_chef = id_chef;
			this.id_restaurante = id_restaurante;
			this.nit = nit;
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

		public RestauranteModel getId_restaurante() {
			return id_restaurante;
		}

		public void setId_restaurante(RestauranteModel id_restaurante) {
			this.id_restaurante = id_restaurante;
		}

		public String getNit() {
			return nit;
		}

		public void setNit(String nit) {
			this.nit = nit;
		}
}
