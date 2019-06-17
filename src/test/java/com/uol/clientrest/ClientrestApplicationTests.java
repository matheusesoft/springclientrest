package com.uol.clientrest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.uol.clientrest.controller.ClienteController;
import com.uol.clientrest.persistence.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClientrestApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@MockBean
	private HttpServletRequest request;
	
	@MockBean
	private ClienteController clienteController;

	Cliente cliente;
	List<Cliente> clientes;

	@Before
	public void setup() throws Exception {
		clientes = new ArrayList<>();
		clientes.add(new Cliente(1, "Matheus Oliveira", 23));
		clientes.add(new Cliente(2, "Karoline Santos", 22));
		clientes.add(new Cliente(3, "Emanuel Oliveira", 24));
		cliente = clientes.get(0);
	}

	@Test
	public void retornaCliente() {
		when(clienteController.buscarClientePorId(cliente.getId())).thenReturn(cliente);
		Cliente response = restTemplate.getForObject(createURLWithPort("/cliente/1"), Cliente.class);
		Cliente expected = new Cliente(1, "Matheus Oliveira", 23);
		assertThat(response.getId()).isEqualTo(expected.getId());
		assertThat(response.getNome()).isEqualTo(expected.getNome());
		assertThat(response.getIdade()).isEqualTo(expected.getIdade());
	}
	
	@Test
	public void retornaClientes() {
		when(clienteController.buscarClientes()).thenReturn(clientes);
		ResponseEntity<Cliente[]> response = restTemplate.getForEntity(createURLWithPort("/cliente/listar"), Cliente[].class);
		Cliente[] responseClientes = response.getBody();
		List<Cliente> expected = clientes;
		assertThat(responseClientes.length).isEqualTo(expected.size());
	}
	
	@Test
	public void deletarCliente() {
		when(clienteController.deletarClientePorId(cliente.getId())).thenReturn("sucess");
		ResponseEntity<String> responseDelete = restTemplate.exchange(createURLWithPort("/cliente/" + cliente.getId()), HttpMethod.DELETE, null, String.class);
		String response = responseDelete.getBody();
		assertThat(response).isEqualTo("sucess");
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
