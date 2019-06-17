package com.uol.clientrest.presistence.dao;

import java.io.Serializable;

import com.uol.clientrest.persistence.model.Temperatura;;

public class TemperaturaDAO implements Serializable {

	private static final long serialVersionUID = 5192670014351997454L;

	private long idCliente;

	private String ipRequisicao;

	public TemperaturaDAO() {
	}

	public TemperaturaDAO(Temperatura clima, String ipRequisicao) {
		this.idCliente = clima.getIdCliente();
		this.ipRequisicao = ipRequisicao;
	}

	public long getClienteId() {
		return idCliente;
	}

	public void setClienteId(long clienteId) {
		this.idCliente = clienteId;
	}

	public String getIpRequest() {
		return ipRequisicao;
	}

	public void setIpRequest(String ipRequest) {
		this.ipRequisicao = ipRequest;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClimaDAO [idCliente=");
		builder.append(idCliente);
		builder.append(", ");
		if (ipRequisicao != null) {
			builder.append("ipRequisicao=");
			builder.append(ipRequisicao);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
	}

}
