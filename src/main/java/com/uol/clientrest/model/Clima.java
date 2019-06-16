package com.uol.clientrest.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Clima {

	@Id
	public String idClima;
	private String idCliente;
	private String ipRequisicao;
	private BigDecimal temperaturaMin;
	private BigDecimal temperaturaMax;
	private String data;
	
	public Clima() { }
		
	@Override
	public String toString() {
		return "Clima [idClima=" + idClima + ", idCliente=" + idCliente + ", data=" + data
				+ ", temperaturaMin=" + temperaturaMin + ", temperaturaMax=" + temperaturaMax
				+ ", ipRequisicao=" + ipRequisicao + "]";
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIpRequisicao() {
		return ipRequisicao;
	}

	public void setIpRequisicao(String ipRequisicao) {
		this.ipRequisicao = ipRequisicao;
	}

	public BigDecimal getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(BigDecimal temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public BigDecimal getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(BigDecimal temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
}
