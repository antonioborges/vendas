package br.com.codigolivre.vendasapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.codigolivre.vendasapi.entities.Usuario;
import br.com.codigolivre.vendasapi.repositories.UsuarioRepository;
import br.com.codigolivre.vendasapi.services.exceptions.DatabaseException;
import br.com.codigolivre.vendasapi.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarioRepository.findAll().forEach(usuarios::add);
		return usuarios;
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	public void delete(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario usuario = usuarioRepository.getOne(id);
			updateData(usuario, obj);
			return usuarioRepository.save(usuario);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	// atualizar os dados do usuario, com base no que veio do obj.
	private void updateData(Usuario usuario, Usuario obj) {
		usuario.setNome(obj.getNome());
		usuario.setEmail(obj.getEmail());
		usuario.setTelefone(obj.getTelefone());
	}
}
