package br.com.codigolivre.vendasapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.codigolivre.vendasapi.entities.Categoria;
import br.com.codigolivre.vendasapi.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> findAll() {
		List<Categoria> categorias = new ArrayList<>();
		categoriaRepository.findAll().forEach(categorias::add);
		return categorias;
	}

	// fazer tratamento de exceção
	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.get();
	}

}
