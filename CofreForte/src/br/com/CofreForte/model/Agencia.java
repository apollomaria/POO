package br.com.CofreForte.model;

public class Agencia {
    public String NOME_BANCO = "JavaBank";
    public static double TAXA_SAQUE = 5.0;
    private static int totalContasAbertas;

    public static void registrarNovaConta() {
        totalContasAbertas++;
    }

    public int getTotalContasAbertas() {
        return totalContasAbertas;
    }
    
}
