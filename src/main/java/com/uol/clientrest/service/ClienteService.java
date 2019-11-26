package com.uol.clientrest.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uol.clientrest.persistence.model.*;
import com.uol.clientrest.persistence.repository.ClienteRepo;
import com.uol.clientrest.presistence.dao.TemperaturaDAO;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepo clienteRepo;
	@Autowired
	private ClimaService climaService;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public Cliente salvar(Cliente cliente, HttpServletRequest request) {
		Cliente resultCliente = clienteRepo.save(cliente);
		Temperatura temperatura = new Temperatura();
		temperatura.setIdCliente(resultCliente.getId());
		TemperaturaDAO temperaturaDAO = new TemperaturaDAO(temperatura, request.getRemoteAddr());
		temperatura = new Temperatura(temperaturaDAO);
		climaService.salvar(temperatura);
		return resultCliente;
	}
	
	public Cliente atualizar(Cliente cliente) {
		if(cliente.getId() == 0 || cliente.getId()<0) {
			throw new RuntimeException("Nenhum ID foi informado!");
		}		
		return clienteRepo.save(cliente);
	}	
	
	public Cliente buscarClientePorId(long id) {
		return clienteRepo.findClienteById(id);
	}
	
	public List<Cliente> buscarClientes() {
		return clienteRepo.findAll();
	}
	
	public void deletarClientePorId(long id) {
		clienteRepo.deleteById(id);
	}


}
