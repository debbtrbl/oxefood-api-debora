package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ProdutoException extends RuntimeException {
    public static final String MSG_VALOR_MIN_MAX_PRODUTO = "Não é permitido inserir produtos com valor inferior a R$ 20 ou superior a R$ 100.";

    public ProdutoException(String msg) {

	super(String.format(msg));
    }

}
