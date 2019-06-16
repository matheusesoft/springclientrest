package com.uol.clientrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.uol.clientrest.model.Cliente;
import com.uol.clientrest.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private ClienteService service;

	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente, HttpServletRequest request) {
		return service.salvar(cliente, request);
	}

	@PutMapping
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return service.atualizar(cliente);
	}

	@DeleteMapping("/{id}")
	public String deletarClientePorId(@PathVariable("id") String id) {
		service.deletarClientePorId(id);
		return "ok";
	}

	@GetMapping(value = "/{id}")
	public Cliente buscarClientePorId(@PathVariable("id") String id) {
		return service.buscarClientePorId(id);
	}

	@GetMapping("/listarclientes")
	public List<Cliente> buscarClientes() {
		return service.buscarClientes();
	}

	@ExceptionHandler
	public ResponseEntity<String> errorHandle(Exception e, WebRequest request) {
		log.error("Ocorreu erro......");
		e.printStackTrace();
		return new ResponseEntity<String>("Ocorreu um erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
