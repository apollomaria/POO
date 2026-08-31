package br.com.StreamingJava.main;

import br.com.StreamingJava.model.Usuario;

public class MainMemoria {
    public static void main(String[] args) throws Exception {
        Usuario user2 = new Usuario("null", "null@email", true);
        Usuario user3 = new Usuario("llun", "null@email", true);

        if (user2.equals(user3)) {
            System.out.println("Usuários duplicados!");
        }

        System.out.println(Usuario.getNomeStreaming() + " Usuários: " + Usuario.getTotalUsuarios());



    }
}
