package br.com.codigolivre.vendasapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codigolivre.vendasapi.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
