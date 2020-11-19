package br.com.codigolivre.vendasapi.entities.enums;

public enum PedidoStatus {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);

	private int code;

	private PedidoStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static PedidoStatus valueOf(int code) {
		for (PedidoStatus valor : PedidoStatus.values()) {
			if (valor.getCode() == code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("O código do PedidoStatus é Inválido");
	}

}
