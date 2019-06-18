package com.uol.clientrest.persistence.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.uol.clientrest.presistence.dao.TemperaturaDAO;

@Entity(name="temperatura")
public class Temperatura {

	@Id @GeneratedValue
	@Column(name="idtemperatura")
	public long idTemperatura;
	@Column(name="idcliente")
	private long idCliente;
	@Column(name="iprequisicao")
	private String ipRequisicao;
	@Column(name="temperaturamin")
	private BigDecimal temperaturaMin;
	@Column(name="temperaturamax")
	private BigDecimal temperaturaMax;
	private String data;
	
	public Temperatura() { }
	
	public Temperatura(TemperaturaDAO temperaturaDAO) {
		this.idCliente = temperaturaDAO.getClienteId();
		this.ipRequisicao = temperaturaDAO.getIpRequest();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Temperatura [idTemperatura=");
		builder.append(idTemperatura);
		builder.append(", ");
		if (idCliente != 0) {
			builder.append("idCliente=");
			builder.append(idCliente);
			builder.append(", ");
		}
		if (data != null) {
			builder.append("data=");
			builder.append(data);
			builder.append(", ");
		}
		if (temperaturaMin != null) {
			builder.append("temperaturaMin=");
			builder.append(temperaturaMin);
			builder.append(", ");
		}
		if (temperaturaMax != null) {
			builder.append("temperaturaMax=");
			builder.append(temperaturaMax);
			builder.append(", ");
		}
		if (ipRequisicao != null) {
			builder.append("ipRequisicao=");
			builder.append(ipRequisicao);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
	}
	
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
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
