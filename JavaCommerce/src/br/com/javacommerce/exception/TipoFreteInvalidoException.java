package br.com.javacommerce.exception;

public class TipoFreteInvalidoException extends RuntimeException {
    public TipoFreteInvalidoException() {
        super("Tipo de frete inválido!");
    }
}
