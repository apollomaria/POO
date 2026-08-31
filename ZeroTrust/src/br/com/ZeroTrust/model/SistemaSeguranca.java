package br.com.ZeroTrust.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SistemaSeguranca {
    private Veiculo[] vagasGaragem;
    private List<Funcionario> catracaPrincipal = new ArrayList<>();
    private Set<Credencial> cofreFisico = new HashSet<>();
    private int totalVagas;

    public SistemaSeguranca(int totalVagas) {
        this.totalVagas = totalVagas;

        // this.vagasGaragem[totalVagas] = vagasGaragem[totalVagas]; 
        vagasGaragem = new Veiculo[totalVagas];
    }

    public void estacionarVeiculo(Veiculo veiculo, int vaga) {
        vagasGaragem[vaga] = veiculo;
        System.out.println("Garagem: Veículo [" + veiculo + "] estacionado na vaga [" + vaga + "]");
    }
    

    public void registrarCatraca(Funcionario funcionario) {
        catracaPrincipal.add(funcionario);
        System.out.println("Catraca: Acesso liberado para [" + funcionario.getNome() + "]");
    }


    public void acessarCofre(Credencial cred) {
        if (cofreFisico.add(cred)) {
            System.out.println("Cofre: Acesso CONCEDIDO. Boas vindas, " + cred.getTitular() + "]");
        } else {
            System.out.println("ALERTA MÁXIMO: Credencial [" + cred.getCodigoHex() + "] BLOQUEADA! Tentativa de clonagem detectada.");
        }
    }

}
