package br.com.codigolivre.vendasapi.services.exceptions;

//cria uma exceção personalizada da camada de serviço da aplicação.
//lança exeções próprias.
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Recurso não encontrado Id " + id);
	}
}
