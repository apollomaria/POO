package br.com.techcorp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControleDeAcesso {
    private List<Funcionario> historicoCatraca = new ArrayList<>();
    private Map<String, Funcionario> autorizadosSalaSegura = new HashMap<>();
    


    public ControleDeAcesso(List<Funcionario> historicoCatraca, Map<String, Funcionario> autorizadosSalaSegura) {
        this.historicoCatraca = historicoCatraca = new ArrayList<>();
        this.autorizadosSalaSegura = autorizadosSalaSegura = new HashMap<>();
    }


    public void registrarPassagem(Funcionario f) {

        historicoCatraca.add(f);
        System.out.println("Funcionário " + f.getNome() + " (ID: " + f.getMatricula() + ") " + "registrado na Catraca!");
    }



    public void concederAcessoSala(Funcionario f) {

        if (autorizadosSalaSegura.containsKey(f.getMatricula())) {
            System.out.println("Aviso: Matrícula (ID: " + f.getMatricula() + ") já registrada na sala. Acesso negado.");
        } else {            
            autorizadosSalaSegura.put(f.getMatricula(), f);
            System.out.println("Acesso de " + f.getNome() + " (ID: " + f.getMatricula() + ") liberado para a Sala Segura.");
        }


    }
}
