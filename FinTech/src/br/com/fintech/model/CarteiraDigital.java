package br.com.fintech.model;

import java.util.ArrayList;
import java.util.List;

import br.com.fintech.exception.LimiteTransacoesExcedidoException;

public class CarteiraDigital {
    private final String codigoCarteira;
    private final int capacidadeMaxima;
    private final List<Transacao> transacoes = new ArrayList<>();

    public CarteiraDigital(String codigoCarteira, int capacidadeMaxima) {
        if (codigoCarteira == null || codigoCarteira.trim().isEmpty()) {
            throw new IllegalArgumentException("Codigo da carteira nao pode ser nulo ou vazio.");
        }
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade maxima deve ser estritamente positiva.");
        }
        this.codigoCarteira = codigoCarteira;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public void adicionarTransacao(Transacao transacao) throws LimiteTransacoesExcedidoException {
        if (transacoes.size() >= capacidadeMaxima) {
            throw new LimiteTransacoesExcedidoException("Carteira '" + this.codigoCarteira + "' atingiu o limite maximo de " + this.capacidadeMaxima + " transacoes.");
        }

        transacoes.add(transacao);
        System.out.println("Transacao '" + transacao.getIdTransacao() + "' adicionada com sucesso.");
    }

    public String getCodigoCarteira() {
        return codigoCarteira;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public double calcularTarifaTotal() {
        return this.transacoes.stream()
                    .mapToDouble(t -> t.getTarifa())
                    .sum();
    }

    public long contarPorTipo(String tipo) {
        return this.transacoes.stream()
                    .filter(t -> t.getTipo().equalsIgnoreCase(tipo))
                    .count();
    }

    public double calcularTarifaPorTipo(String tipo) {
        return this.transacoes.stream()
                    .filter(t -> t.getTipo().equalsIgnoreCase(tipo))
                    .mapToDouble(t -> t.getTarifa())
                    .sum();
    }

}
