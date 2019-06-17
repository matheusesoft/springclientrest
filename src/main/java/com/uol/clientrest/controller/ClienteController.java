package com.uol.clientrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.uol.clientrest.persistence.model.Cliente;
import com.uol.clientrest.webservice.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping("/listar")
	public List<Cliente> buscarClientes() {
		return service.buscarClientes();
	}
	
	@GetMapping(value = "/{id}")
	@Cacheable(value = "cliente", key = "#id")
	public Cliente buscarClientePorId(@PathVariable("id") long id) {
		return service.buscarClientePorId(id);
	}
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente, HttpServletRequest request) {
		return service.salvar(cliente, request);
	}

	@PutMapping
	@CachePut(value = "cliente", key = "#cliente.id")
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return service.atualizar(cliente);
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "cliente", key = "#id")
	public String deletarClientePorId(@PathVariable("id") long id) {
		service.deletarClientePorId(id);
		return "sucess";
	}

	@ExceptionHandler
	public ResponseEntity<String> errorHandle(Exception e, WebRequest request) {
		e.printStackTrace();
		return new ResponseEntity<String>("Erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
