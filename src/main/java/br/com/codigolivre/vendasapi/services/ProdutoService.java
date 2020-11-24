package br.com.codigolivre.vendasapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.codigolivre.vendasapi.entities.Produto;
import br.com.codigolivre.vendasapi.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> findAll() {
		List<Produto> produtos = new ArrayList<>();
		produtoRepository.findAll().forEach(produtos::add);
		return produtos;
	}

	// fazer tratamento de excessão.
	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.get();

	}
}
