package br.com.StreamingJava.model;

public class ProcessadorPagamento {
    public void finalizarCompra(double valor, Pagamento formaPagamento) {
        formaPagamento.processar(valor);
    }
}
