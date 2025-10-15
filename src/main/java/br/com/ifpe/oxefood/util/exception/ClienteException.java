package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ClienteException extends RuntimeException {
    public static final String MSG_PREFIXO_DDD = "Não é permitido inserir clientes com DDD diferente de 81.";

    public ClienteException(String msg) {

	super(String.format(msg));
    }
}
