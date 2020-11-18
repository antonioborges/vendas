package br.com.codigolivre.vendasapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codigolivre.vendasapi.entities.Pedido;
import br.com.codigolivre.vendasapi.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> pedidos = pedidoService.findAll();
		return ResponseEntity.ok().body(pedidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido obj = pedidoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
