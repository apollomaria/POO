package br.com.StreamingJava.main;

import br.com.StreamingJava.model.PagamentoCartao;
import br.com.StreamingJava.model.PagamentoPix;
import br.com.StreamingJava.model.ProcessadorPagamento;

public class MainPagamento {
    public static void main(String[] args) {
        ProcessadorPagamento processadorPagamento = new ProcessadorPagamento();

        PagamentoPix pix = new PagamentoPix();
        PagamentoCartao cartao = new PagamentoCartao();

        processadorPagamento.finalizarCompra(100, cartao);
        processadorPagamento.finalizarCompra(100, pix);

    }
}
