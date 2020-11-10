package br.com.codigolivre.vendasapi.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.codigolivre.vendasapi.entities.Usuario;
import br.com.codigolivre.vendasapi.repositories.UsuarioRepository;

//classe especifica de configuração.
@Configuration
//define a classe como uma configuração especifica para o perfil de teste.
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UsuarioRepository usuarioRepository;

	public TestConfig(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		usuarioRepository.saveAll(Arrays.asList(u1, u2));

	}

}
