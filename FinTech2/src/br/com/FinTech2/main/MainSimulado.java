package br.com.FinTech2.main;

import java.util.HashSet;
import java.util.Set;

import br.com.FinTech2.exception.LimiteTransacoesExcedidoException;
import br.com.FinTech2.model.CarteiraDigital;
import br.com.FinTech2.model.GatewayPagamentos;
import br.com.FinTech2.model.Transacao;

public class MainSimulado {
    public static void main(String[] args) {
        // P01
        Transacao t1 = new Transacao("TX-101-BR", "PIX", 400, 2);
        Transacao t2 = new Transacao("TX-102-BR", "CARTAO", 1500, 45);
        Transacao t3 = new Transacao("TX-103-BR", "PIX", 600, 3);
        Transacao t4 = new Transacao("TX-104-BR", "BOLETO", 200, 2.5);

        System.out.println(t1);
        System.out.println(t4);



        // P02
        Set<Transacao> auditoria = new HashSet<>();

        auditoria.add(t1);
        Transacao clone = new Transacao("TX-101-BR", "PIX", 400, 2);
        auditoria.add(clone);
        auditoria.add(t2);
        System.out.println("Tamanho da Auditoria (HashSet): " + auditoria.size());



        // P03
        try {
            Transacao erro = new Transacao("", "PIX", 10, 0.1);
        } catch (IllegalArgumentException e) {
            System.out.println("Construtor validado: " + e.getMessage());
        }



        // P04
        CarteiraDigital carteira = new CarteiraDigital("WALLET-01", 3);
        try {
            carteira.adicionarTransacao(t1);
            carteira.adicionarTransacao(t2);
            carteira.adicionarTransacao(t3);
        } catch (LimiteTransacoesExcedidoException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }
       


        // P05
        try {
            carteira.adicionarTransacao(t4);
        } catch (LimiteTransacoesExcedidoException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }


        // P06 
        System.out.println("Tarifa total da carteira: R$" + carteira.calcularTarifaTotal());
        System.out.println("Transacoes PIX: " + carteira.contarPorTipo("PIX"));
    
        

        // P07
        System.out.println("Tarifa apurada para PIX: R$" + carteira.calcularTarifaPorTipo("PIX"));
    

        // P08
        GatewayPagamentos gateway = new GatewayPagamentos();
        gateway.cadastrarCarteira(carteira);
        CarteiraDigital recuperada = gateway.buscarCarteira("WALLET-01");
        System.out.println("Carteira recuperada do gateway: " + recuperada.getCodigoCarteira());
    }
}
