package br.com.CofreForte.main;

import br.com.CofreForte.model.Agencia;
import br.com.CofreForte.model.Cliente;
import br.com.CofreForte.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) throws Exception {
        Cliente c1 = new Cliente("123", "Apollo", "apollo@email.com");
        Cliente c2 = new Cliente("123", "Maria", "maria@email.com");
        // Cliente c3 = new Cliente("321", "Pollo", "pollo@email.com");

        if (c1.equals(c2)) {
            System.out.println("Clientes Iguais!");
        }

        ContaBancaria conta1 = new ContaBancaria("1", 50, c1);
        // ContaBancaria conta2 = new ContaBancaria("2", 50, c3);
        
        System.out.println("Tentativa de Saque: " + conta1.sacar(50));

        Agencia agencia = new Agencia();

        System.out.println("Total de Contas Abertas: " + agencia.getTotalContasAbertas());
    }

}
