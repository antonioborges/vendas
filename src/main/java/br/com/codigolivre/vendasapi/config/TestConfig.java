package br.com.codigolivre.vendasapi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.codigolivre.vendasapi.entities.Categoria;
import br.com.codigolivre.vendasapi.entities.Pedido;
import br.com.codigolivre.vendasapi.entities.Usuario;
import br.com.codigolivre.vendasapi.entities.enums.PedidoStatus;
import br.com.codigolivre.vendasapi.repositories.CategoriaRepository;
import br.com.codigolivre.vendasapi.repositories.PedidoRepository;
import br.com.codigolivre.vendasapi.repositories.UsuarioRepository;

//classe especifica de configuração.
@Configuration
//define a classe como uma configuração especifica para o perfil de teste.
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UsuarioRepository usuarioRepository;

	private PedidoRepository pedidoRepository;

	private CategoriaRepository categoriaRepository;

	public TestConfig(UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository,
			CategoriaRepository categoriaRepository) {

		this.usuarioRepository = usuarioRepository;
		this.pedidoRepository = pedidoRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

		usuarioRepository.saveAll(Arrays.asList(u1, u2));

		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

	}

}
