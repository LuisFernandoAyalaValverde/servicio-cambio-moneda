package com.empresa.app.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_CAMBIO")
public class TipoCambio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "moneda_origen_id")
    private Moneda monedaOrigen;
	
	@ManyToOne
    @JoinColumn(name = "moneda_destino_id")
    private Moneda monedaDestino;
	
	@Column(name = "valor")
    private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Moneda getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(Moneda monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public Moneda getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(Moneda monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	

}
