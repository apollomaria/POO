package br.com.nexustech.main;

import br.com.nexustech.exception.BanidoException;
import br.com.nexustech.exception.NivelInsuficienteException;
import br.com.nexustech.model.Masmorra;
import br.com.nexustech.model.MatchMaker;
import br.com.nexustech.model.ModoCasual;
import br.com.nexustech.model.ModoRanqueado;

public class Main {
    public static void main(String[] args) {

        // NÍVEL 1 ---------------------------------------------------------------------------------
        // EXERCÍCIO 1
        int kills = 15;
        int deaths = 0;

        // System.out.println(kills / deaths);
        // ERRO NO CONSOLE:
        // "Exception in thread "main" java.lang.ArithmeticException: / by zero
        // at br.com.nexustech.main.Main.main(Main.java:9)"


        // EXERCÍCIO 2
        try {
            System.out.println(kills / deaths);
        } catch (ArithmeticException e) {
            System.out.println("Taxa K/D: Jogador Invicto!");
        }


        // EXERCÍCIO 3
        String[] inventario = new String[3];

        try {
            inventario[5] = "Espada";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inventário cheio!");
        }


        // EXERCÍCIO 4
        String jogador = null;

        // dead code pedagógico ! 
        if (jogador != null) {
            System.out.println("Nome do Jogador: " + jogador);
        } else {
            System.out.println("Jogador desconectado.");
        }


        // NÍVEL 2
        // EXERCÍCIO 6
        try {
            conectarServidor();
        } catch (Exception e) {
            e.getMessage();
        } 
        // EXERCÍCIO 7
        finally {
            System.out.println("Fechando portas de rede do jogo...");
        }
        


        // NÍVEL 3 ---------------------------------------------------------------------------------
        // EXERCÍCIO 9

        try {
            Masmorra masmorra = new Masmorra();
            masmorra.entrar(20);
        } catch (NivelInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        // NÍVEL BOSS ---------------------------------------------------------------------------------
        // EXERCÍCIO 14

        try {
            MatchMaker matchMaker = new MatchMaker();
            ModoCasual modoCasual = new ModoCasual();
            ModoRanqueado modoRanqueado = new ModoRanqueado();
            matchMaker.encontrarSala(modoCasual, false);
            matchMaker.encontrarSala(modoRanqueado, false);
            matchMaker.encontrarSala(modoCasual, true);
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }



    }


    // -------------------------------------------------------------------------------------------------------


    // NÍVEL 2 ---------------------------------------------------------------------------------
    // EXERCÍCIO 5
    public static void conectarServidor() throws Exception {
        throw new Exception("Servidor caiu!");
    }

}
