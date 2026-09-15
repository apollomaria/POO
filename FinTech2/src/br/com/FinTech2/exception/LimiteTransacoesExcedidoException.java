package br.com.FinTech2.exception;

public class LimiteTransacoesExcedidoException extends Exception {
    public LimiteTransacoesExcedidoException(String mensagem) {
        super(mensagem);
    }
}
