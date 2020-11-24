package br.com.codigolivre.vendasapi.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.codigolivre.vendasapi.entities.Categoria;
import br.com.codigolivre.vendasapi.entities.Pedido;
import br.com.codigolivre.vendasapi.entities.Produto;
import br.com.codigolivre.vendasapi.entities.Usuario;
import br.com.codigolivre.vendasapi.entities.enums.PedidoStatus;
import br.com.codigolivre.vendasapi.repositories.CategoriaRepository;
import br.com.codigolivre.vendasapi.repositories.PedidoRepository;
import br.com.codigolivre.vendasapi.repositories.ProdutoRepository;
import br.com.codigolivre.vendasapi.repositories.UsuarioRepository;

//classe especifica de configuração.
@Configuration
//define a classe como uma configuração especifica para o perfil de teste.
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UsuarioRepository usuarioRepository;

	private PedidoRepository pedidoRepository;

	private CategoriaRepository categoriaRepository;

	private ProdutoRepository produtoRepository;

	public TestConfig(UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository,
			CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {

		this.usuarioRepository = usuarioRepository;
		this.pedidoRepository = pedidoRepository;
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");

		Produto prod1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.",
				new BigDecimal(90.5), "");
		Produto prod2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.",
				new BigDecimal(2190.0), "");
		Produto prod3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.",
				new BigDecimal(1250.0), "");
		Produto prod4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", new BigDecimal(1200.0),
				"");
		Produto prod5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.",
				new BigDecimal(100.99), "");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);

		usuarioRepository.saveAll(Arrays.asList(u1, u2));

		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

	}

}
