package com.uol.clientrest.webservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uol.clientrest.persistence.model.*;
import com.uol.clientrest.persistence.repository.ClienteRepo;
import com.uol.clientrest.presistence.dao.TemperaturaDAO;
import com.uol.clientrest.presistence.dao.IPVigilanteDAO;
import com.uol.clientrest.properties.IPVigilanteProperties;
import com.uol.clientrest.publisher.*;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepo repository;
	
	@Autowired
	private TemperaturaPublisher temperaturaPublisher;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IPVigilanteProperties ipvigilanteProperties;
	
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente salvar(Cliente cliente, HttpServletRequest request) {
		Cliente resultCliente = repository.save(cliente);
		
		Temperatura temperatura = new Temperatura();
		temperatura.setIdCliente(resultCliente.getId());
		
		TemperaturaDAO temperaturaDAO = new TemperaturaDAO(temperatura, identificaIp());
		
		temperaturaPublisher.publish(temperaturaDAO);
		
		return resultCliente;
	}
	
	public Cliente atualizar(Cliente cliente) {
		if(cliente.getId() == 0 || cliente.getId()<0) {
			throw new RuntimeException("É necessário informar ID");
		}
		
		return repository.save(cliente);
	}	
	
	public Cliente buscarClientePorId(long id) {
		return repository.findClienteById(id);
	}
	
	public List<Cliente> buscarClientes() {
		return repository.findAll();
	}
	
	public void deletarClientePorId(long id) {
		repository.deleteById(id);
	}
	
	private String identificaIp() {
		String url = ipvigilanteProperties.getUrlIpv4();
		return restTemplate.getForObject(url, IPVigilanteDAO.class).getData().getIpv4();
	}


}
