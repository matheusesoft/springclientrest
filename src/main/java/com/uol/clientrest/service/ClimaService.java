package com.uol.clientrest.service;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uol.clientrest.presistence.dao.CidadesDAO;
import com.uol.clientrest.presistence.dao.IPVigilanteDAO;
import com.uol.clientrest.presistence.dao.ClimaDAO;
import com.uol.clientrest.config.ClimaProperties;
import com.uol.clientrest.config.IPVigilanteProperties;
import com.uol.clientrest.persistence.model.Temperatura;
import com.uol.clientrest.persistence.repository.TemperaturaRepo;

@Service
public class ClimaService {
	@Autowired
	private TemperaturaRepo temperaturaRepo;
	@Autowired
	private ClimaProperties climaProperties;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private IPVigilanteProperties ipvigilante;

	public Temperatura salvar(Temperatura temperatura) {
		IPVigilanteDAO ipvigilante = localizaLatLong(temperatura.getIpRequisicao());
		Calendar dataHoje = Calendar.getInstance();
		localizaTemperatura(temperatura, ipvigilante.getData().getLatitude(), ipvigilante.getData().getLongitude(), dataHoje);
		return temperaturaRepo.save(temperatura);
	}

	private void localizaTemperatura(Temperatura temperatura, String latitude, String longitude, Calendar data) {
		CidadesDAO[] listaCidades = listaCidades(latitude, longitude);
		Integer idCidade = listaCidades[0].getWoeid();
		localizaTemperaturaMinimaMaxima(data, idCidade, temperatura);
	}

	private void localizaTemperaturaMinimaMaxima(Calendar data, Integer idCidade, Temperatura temperatura) {
		int ano = data.get(Calendar.YEAR);
		int mes = data.get(Calendar.MONTH) + 1;
		int dia = data.get(Calendar.DAY_OF_MONTH);

		String urlTemperatura = climaProperties.getUrlTemperaturaPorCidadeId();
		ResponseEntity<ClimaDAO[]> responseTemperaturaDAO = restTemplate.getForEntity(urlTemperatura, ClimaDAO[].class, idCidade, ano, mes, dia);

		BigDecimal temperaturaMin = new BigDecimal(Float.MAX_VALUE);
		BigDecimal temperaturaMax = new BigDecimal(Float.MIN_VALUE);

		for (ClimaDAO climaDAO : responseTemperaturaDAO.getBody()) {
			if (climaDAO.getApplicableDate() == null) {
				continue;
			}

			if(temperatura.getData() == null) {
				temperatura.setData(climaDAO.getApplicableDate());
			}
			
			if(climaDAO.getMinTemp().compareTo(temperaturaMin) < 0) {
				temperaturaMin = climaDAO.getMinTemp();
			}
			
			if(climaDAO.getMaxTemp().compareTo(temperaturaMax) > 0) {
				temperaturaMax = climaDAO.getMaxTemp();
			}
		}
		
		temperatura.setTemperaturaMin(temperaturaMin);
		temperatura.setTemperaturaMax(temperaturaMax);
	}

	private CidadesDAO[] listaCidades(String latitude, String longitude) {
		String url = climaProperties.getUrlCidades();
		ResponseEntity<CidadesDAO[]> responseEntityCidadesDAO = restTemplate.getForEntity(url, CidadesDAO[].class, latitude, longitude);
		CidadesDAO[] listaCidades = responseEntityCidadesDAO.getBody();
		return listaCidades;
	}

	private IPVigilanteDAO localizaLatLong(String ipOrigem) {
		String url = ipvigilante.getUrlIPVigilante();
		if (ipOrigem.equals("127.0.0.1") || ipOrigem.equals("0:0:0:0:0:0:0:1")) {
			ipOrigem = identificaIp();
		}
		return restTemplate.getForObject(url, IPVigilanteDAO.class, ipOrigem);
	}
	
	private String identificaIp() {
		String url = ipvigilante.getUrlIpv4();
		return restTemplate.getForObject(url, IPVigilanteDAO.class).getData().getIpv4();
	}
	
}
