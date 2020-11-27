package br.com.codigolivre.vendasapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codigolivre.vendasapi.entities.ItensDoPedido;

@Repository
public interface ItensDoPedidoRepository extends JpaRepository<ItensDoPedido, Long> {

}
