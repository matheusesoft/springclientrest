package com.uol.clientrest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:metaweather.properties")
public class ClimaProperties {

	@Value("${url.cidades}")
	private String urlCidades;

	@Value("${url.temperatura.cidadeid}")
	private String urlTemperaturaPorCidadeId;

	public String getUrlCidades() {
		return urlCidades;
	}

	public void setUrlCidades(String urlCidades) {
		this.urlCidades = urlCidades;
	}

	public String getUrlTemperaturaPorCidadeId() {
		return urlTemperaturaPorCidadeId;
	}

	public void setUrlTemperaturaPorCidadeId(String urlTemperaturaPorCidadeId) {
		this.urlTemperaturaPorCidadeId = urlTemperaturaPorCidadeId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClimaProperties [urlCidades=");
		builder.append(urlCidades);
		builder.append(", ");
		if (urlTemperaturaPorCidadeId != null) {
			builder.append("urlTemperaturaPorCidadeId=");
			builder.append(urlTemperaturaPorCidadeId);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
	}

}