package br.com.StreamingJava.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sede {
    private String[] vagasGaragem = new String[3];
    private List<Credencial> historicoCatraca = new ArrayList<>();
    private Set<Credencial> acessoCofre = new HashSet<>();

    public void estacionarVeiculo(String placa, int vaga) {
        vagasGaragem[vaga] = placa;
        System.out.println("Veículo [" + placa + "] estacionado na vaga [" + vaga + "].");
    }

    public void registrarPassagemCatraca(Credencial c) {
        historicoCatraca.add(c);
        System.out.println("Credencial " + c + " registrada na Catraca.");
    }


    public boolean autorizarEntradaCofre(Credencial c) {
        if (acessoCofre.add(c)) {
            System.out.println("Acesso permitido!");
            return true;
        } else {
            System.out.println("Alerta de Segurança: Tentativa de acesso duplicado com credencial já ativa no cofre.");
            return false;
        }
    }
}
