package com.uol.clientrest.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:ipvigilante.properties")
public class IPVigilanteProperties {

	@Value("${url.ipvigilante}")
	private String urlIPVigilante;

	@Value("${url.ipvigilante.ipv4}")
	private String urlIpv4;

	
	public String getUrlIpv4() {
		return urlIpv4;
	}

	public void setUrlIpv4(String urlIpv4) {
		this.urlIpv4 = urlIpv4;
	}

	public String getUrlIPVigilante() {
		return urlIPVigilante;
	}

	public void setUrlIPVigilante(String urlIPVigilante) {
		this.urlIPVigilante = urlIPVigilante;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IPVigilanteProperties [urlIPVigilante=");
		builder.append(urlIPVigilante);
		builder.append(", ");
		if (urlIpv4 != null) {
			builder.append("urlIpv4=");
			builder.append(urlIpv4);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
	}

}