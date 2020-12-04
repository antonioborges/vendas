package br.com.codigolivre.vendasapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.codigolivre.vendasapi.entities.Usuario;
import br.com.codigolivre.vendasapi.repositories.UsuarioRepository;

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

	// fazer tratamento de excessão.
	public Usuario findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.get();
	}

	public Usuario insert(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}

	public Usuario update(Long id, Usuario obj) {
		Usuario usuario = usuarioRepository.getOne(id);
		updateData(usuario, obj);
		return usuarioRepository.save(usuario);
	}

	// atualizar os dados do usuario, com base no que veio do obj.
	private void updateData(Usuario usuario, Usuario obj) {
		usuario.setNome(obj.getNome());
		usuario.setEmail(obj.getEmail());
		usuario.setTelefone(obj.getTelefone());
	}
}
