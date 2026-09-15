package br.com.FinTech2.model;

import java.util.ArrayList;
import java.util.List;

import br.com.FinTech2.exception.LimiteTransacoesExcedidoException;

public class CarteiraDigital {
    private String codigoCarteira;
    private int capacidadeMaxima;
    private List<Transacao> transacoes = new ArrayList<>();

    public CarteiraDigital(String codigoCarteira, int capacidadeMaxima) {
        if (codigoCarteira == null || codigoCarteira.trim().isEmpty()) {
            throw new IllegalArgumentException("ID da carteira nao pode ser nulo ou vazio");
        }
        this.codigoCarteira = codigoCarteira;
        this.capacidadeMaxima = capacidadeMaxima;
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

    
    public void adicionarTransacao(Transacao transacao) throws LimiteTransacoesExcedidoException {
        if (this.transacoes.size() >= this.capacidadeMaxima) {
            throw new LimiteTransacoesExcedidoException(String.format("Carteira '%s' atingiu o limite maximo de %d transacoes.", this.codigoCarteira, this.capacidadeMaxima));
        }

        transacoes.add(transacao);
        System.out.println("Transação " + transacao.getIdTransacao() + " adicionada com sucesso!");
    }


    public double calcularTarifaTotal() {
        return this.transacoes.stream()
                                .mapToDouble(t -> t.getTarifa())
                                .sum()
                                ;
    }
    

    public long contarPorTipo(String tipo) {
        return this.transacoes.stream()
                                .filter(t -> t.getTipo().equalsIgnoreCase(tipo))
                                .count()
                                ;
    }


    public double calcularTarifaPorTipo(String tipo) {
        return this.transacoes.stream()
                                .filter(t -> t.getTipo().equalsIgnoreCase(tipo))
                                .mapToDouble(t -> t.getTarifa())
                                .sum()
                                ;
    }

    @Override
    public String toString() {
        return "[" + codigoCarteira + "]";
    }

}
