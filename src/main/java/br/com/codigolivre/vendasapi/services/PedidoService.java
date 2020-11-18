package br.com.codigolivre.vendasapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.codigolivre.vendasapi.entities.Pedido;
import br.com.codigolivre.vendasapi.repositories.PedidoRepository;

@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public List<Pedido> findAll() {
		List<Pedido> pedidos = new ArrayList<>();
		pedidoRepository.findAll().forEach(pedidos::add);
		return pedidos;
	}

	// fazer tratamento de erro.
	public Pedido findById(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.get();
	}

}
