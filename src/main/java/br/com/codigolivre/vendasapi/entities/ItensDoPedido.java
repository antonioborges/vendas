package br.com.codigolivre.vendasapi.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.codigolivre.vendasapi.entities.pk.PedidoItemPK;

@Entity
public class ItensDoPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	// classe auxiliar com id composto é preciso instanciar.
	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();

	private Integer quantidade;
	private BigDecimal preco;

	public ItensDoPedido() {

	}

	// recebe como argumento Produto e Pedido
	// Instânciando o ItensDoPedido passando os argumentos
	public ItensDoPedido(Produto produto, Pedido pedido, Integer quantidade, BigDecimal preco) {
		id.setProduto(produto);// atribui o produto no PedidoItemPK.
		id.setPedido(pedido);// atribui o pedido no PedidoItemPK.
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	@JsonIgnore // ignorar o chamado do Pedido.
	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensDoPedido other = (ItensDoPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItensDoPedido [id=" + id + ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}

}
