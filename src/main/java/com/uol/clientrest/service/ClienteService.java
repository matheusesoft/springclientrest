package com.uol.clientrest.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.uol.clientrest.model.Cliente;

@Service
public interface ClienteService {
	
	public Cliente salvar(Cliente cliente);
	
	public Cliente salvar(Cliente cliente, HttpServletRequest request);
	
	public Cliente atualizar(Cliente cliente);
	
	public Cliente buscarClientePorId(String id);
	
	public List<Cliente> buscarClientes();
	
	public void deletarClientePorId(String id);

}