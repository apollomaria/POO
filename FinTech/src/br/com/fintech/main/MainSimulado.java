package br.com.fintech.main;

import java.util.HashSet;
import java.util.Set;

import br.com.fintech.exception.LimiteTransacoesExcedidoException;
import br.com.fintech.model.CarteiraDigital;
import br.com.fintech.model.GatewayPagamentos;
import br.com.fintech.model.Transacao;

public class MainSimulado {
    public static void main(String[] args) {
        Transacao t1 = new Transacao("TX-101-BR", "PIX", 400, 2.00);
        Transacao t2 = new Transacao("TX-102-BR", "CARTAO", 1500, 45.00);
        Transacao t3 = new Transacao("TX-103-BR", "PIX", 600, 3.00);
        Transacao t4 = new Transacao("TX-104-BR", "BOLETO", 200, 2.50);
        
        System.out.println(t1);
        System.out.println(t4);



        Set<Transacao> auditoria = new HashSet<>();
        auditoria.add(t1);
        Transacao clone = new Transacao("TX-101-BR", "PIX", 990.00, 4.95);
        auditoria.add(clone);
        auditoria.add(t2);

        System.out.println("Tamanho da auditoria: " + auditoria.size());



        try {
            new Transacao("", "PIX", 10, 0.1);
        } catch (IllegalArgumentException e) {
            System.out.println("Construtor validado: " + e.getMessage());
        }
    


        CarteiraDigital carteira = new CarteiraDigital("WALLET-01", 3);
        try {
            carteira.adicionarTransacao(t1);
            carteira.adicionarTransacao(t2);
            carteira.adicionarTransacao(t3);
        } catch (LimiteTransacoesExcedidoException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            carteira.adicionarTransacao(t4);
        } catch (LimiteTransacoesExcedidoException e) {
            System.out.println(e.getMessage());
        }
        

        System.out.println("Tarifa total da carteira: R$" + carteira.calcularTarifaTotal());
        System.out.println("Transações PIX: R$"+ carteira.contarPorTipo("PIX"));
        System.out.println("Tarifa apurada para PIX: R$" + carteira.calcularTarifaPorTipo("PIX"));
    
       GatewayPagamentos gateway = new GatewayPagamentos();
       gateway.cadastrarCarteira(carteira);
       System.out.println(gateway.buscarCarteira("WALLET-01"));
    }
}
